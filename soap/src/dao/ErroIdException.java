package dao;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "ErroIdFault")
public class ErroIdException extends Exception {

	public ErroIdException(String msg) {
		super(msg);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault(new Date() , "ID Invalido testeeeee");
	}

}
