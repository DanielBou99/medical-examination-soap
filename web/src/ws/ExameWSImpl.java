package ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import dao.ExameDAO;

@WebService(endpointInterface = "ws.ExameWS", serviceName ="ExameWS")
public class ExameWSImpl implements ExameWS {
	
	@Override
	public List<Exame> todosOsExames(Filtros filtros) throws ErroIdException {
		
		ExameDAO exameDao = new ExameDAO();
		
		List<Filtro> lista = filtros.getExame();
		
		ArrayList<Exame> dados = exameDao.pegarDados(lista);
		
		return dados;
		
	}

}
