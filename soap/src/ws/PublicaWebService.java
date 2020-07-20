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
