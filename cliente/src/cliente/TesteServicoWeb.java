package cliente;

import java.util.List;

public class TesteServicoWeb {


	public static void main(String[] args) {
	
	ExameWS exame = new ExameWS_Service().getExameWSImplPort(); // Objeto Proxy para estabelecer conexão
	
	Filtros filtros = new Filtros();
	Filtro filtro = new Filtro();
	
	filtro.setId(30);
	
	filtros.getExame().add(filtro);
	
	try {
		List<Exame> todosOsExames = exame.todosOsExames(filtros);
		
		for (Exame exame2 : todosOsExames) {
			System.out.println(exame2);
		}
		
	} catch (ErroIdException e) {
		e.printStackTrace();
	}
	
	}
	
}
