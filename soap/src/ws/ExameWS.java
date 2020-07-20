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
