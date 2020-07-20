package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import factory.DBUtil;
import modelo.Exame;
import modelo.Filtro;

public class ExameDAO {
	
	private static Map<String, Exame> ITENS = new LinkedHashMap<>();
	
	public ExameDAO() {
		
	}
	
	public static List<Exame> pegarTodosExames() {
		List<Exame> listaExames = new ArrayList<Exame>();
		
		try {
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("select * from exame");
			
			while(rs.next()) {
				Exame exame = new Exame(rs.getString("nomeExame"));
				exame.setId(rs.getInt("idExame"));
				
				listaExames.add(exame);
			}
			DBUtil.closeConnection(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaExames;
	}
	
	public static Exame pegarExamePeloId(String exameId) {
		Exame exame = null;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("select * from exame where idExame = ?");
			ps.setString(1, exameId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				exame = new Exame(rs.getInt("idExame"), rs.getString("nomeExame"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return exame;
	}

	public ArrayList<Exame> pegarDados(List<Filtro> filtros) throws ErroIdException {
			
		ITENS.clear();
		
		try {
			// null é ? no parametro do SoapUI
			if (filtros.get(0).getId() == null) {
				popularItensNoMapa();
				System.out.println("Todos itens");
			} else {
				System.out.println("Unico Item");
				Integer id = filtros.get(0).getId();
				adicionarItemNoMapa(id);
			}
		} catch (Exception e) {
			throw new ErroIdException(e.getMessage());
		}
		
		ArrayList<Exame> resultados = new ArrayList<Exame>();
		Collection<Exame> todosItens = ITENS.values();
		
		resultados.addAll(todosItens);
		return resultados;
		
	}
	
	private void popularItensNoMapa() {
		List<Exame> exames = pegarTodosExames();
		
		for (Exame exame : exames) {
			ITENS.put(String.valueOf(exame.getId()), exame);
		}
	}
	
	private void adicionarItemNoMapa(Integer id) {
		
		Exame exame = pegarExamePeloId(String.valueOf(id));
		
		ITENS.put(String.valueOf(exame.getId()), exame);
	}


}
