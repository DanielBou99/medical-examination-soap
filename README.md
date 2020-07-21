# medical-examination-soap

<h2><b>PublicaWebService</b></h2>
Classe responsável por publicar serviço.


```
package ws;


import javax.xml.ws.Endpoint;

public class PublicaWebService {
	
	public static void main(String[] args) {
		
		ExameWS service = new ExameWS();
		String url = "http://localhost:8080/examews";
		System.out.println(url  + "?wsdl");
		
		Endpoint.publish(url, service);
		
	}
}
```

<h2><b>ExameWS</b></h2>
Responsável por:
1. Receber os dados da requisição do cliente.
2. Chamar o método responsável pelo Business.
<i>WebService</i> Indica que é um Serviço Web.
<i>@WebMethod(operationName = "TodosOsExames")</i> Altera o nome do método na requisição.
<i>WebResult(name = "exame")</i>  É o nome do elemento XML que representa o valor de retorno.
<i>WebParam(name="filtros")</i> Nome do atributo wsdl que representa o parâmetro.

```
package ws;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import dao.ErroIdException;
import dao.ExameDAO;
import modelo.Exame;
import modelo.Filtro;
import modelo.Filtros;

@WebService
public class ExameWS {
	
	private ExameDAO dao = new ExameDAO();
	
	@WebMethod(operationName = "TodosOsExames")
	@WebResult(name = "exame")
	public List<Exame> getExames(@WebParam(name="filtros") Filtros filtros) throws ErroIdException {
		
		List<Filtro> lista = filtros.getLista();
		
		return dao.pegarDados(lista);
	}
	
}

```

<h2><b>Filtros</b></h2>

<i>@XmlAccessorType(XmlAccessType.FIELD)</i> Permite acessar os atributos da classe.
<i>@XmlElement(name="exame")</i> Nome do grupo de dados Filtro.

```
package modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Filtros {

	@XmlElement(name="exame")
	private List<Filtro> filtros;

	public Filtros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

	Filtros() {
	}
	
	public List<Filtro> getLista() {
		return filtros;
	}
	
}
```


<h2><b>Filtro</b></h2>
Dados que serão enviados pelo cliente.

```
package modelo;


public class Filtro {

	private Integer id;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Filtro [id=" + id + "]";
	}
	
}

```

<h2><b>ExameDAO</b></h2>
Classe que faz o business, acessa o banco de dados e devolve uma lista com as informações.
Situações:
-> Se o ID do exame não existir, lança uma ErroIdException.
-> Se o ID existir, ele devolve os dados do exame.
-> Se o ID for negativo, ele devolve todos os exames do Banco de Dados.
	
```
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
import modelo.Filtro;
import ws.Exame;

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
				Exame exame = new Exame();
				exame.setNomeExame(rs.getString("nomeExame"));
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
				exame = new Exame();
				exame.setId(rs.getInt("idExame"));
				exame.setNomeExame(rs.getString("nomeExame"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return exame;
	}

	public ArrayList<Exame> pegarDados(List<ws.Filtro> lista) throws ws.ErroIdException {
			
		ITENS.clear();
		
		try {
			// null é ? no parametro do SoapUI
			if (lista.get(0).getId() < 0) {
				popularItensNoMapa();
				System.out.println("Todos itens");
			} else {
				System.out.println("Unico Item");
				Integer id = lista.get(0).getId();
				adicionarItemNoMapa(id);
			}
		} catch (Exception e) {
			throw new ws.ErroIdException("ID do Exame não existe.");
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
```

<h2><b>ErroIdException</b></h2>

<i>@WebFault(name = "ErroIdFault")</i> Mapeia as falhas de WSDL para as exceções Java. O atributo name especifica o nome local do elemento XML que representa a falha correspondente no arquivo WSDL. 

```
package dao;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "ErroIdFault")
public class ErroIdException extends Exception {

	public ErroIdException(String msg) {
		super(msg);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault(new Date() , "ID Invalido");
	}

}
```