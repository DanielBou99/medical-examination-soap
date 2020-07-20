
package ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.13
 * 2020-07-20T19:25:48.461-03:00
 * Generated source version: 2.7.13
 */

@WebFault(name = "ErroIdFault", targetNamespace = "http://ws/")
public class ErroIdException extends Exception {
    
    private ws.InfoFault erroIdFault;

    public ErroIdException() {
        super();
    }
    
    public ErroIdException(String message) {
        super(message);
    }
    
    public ErroIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErroIdException(String message, ws.InfoFault erroIdFault) {
        super(message);
        this.erroIdFault = erroIdFault;
    }

    public ErroIdException(String message, ws.InfoFault erroIdFault, Throwable cause) {
        super(message, cause);
        this.erroIdFault = erroIdFault;
    }

    public ws.InfoFault getFaultInfo() {
        return this.erroIdFault;
    }
}
