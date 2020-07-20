
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exame_QNAME = new QName("http://ws/", "exame");
    private final static QName _ErroIdFault_QNAME = new QName("http://ws/", "ErroIdFault");
    private final static QName _TodosOsExamesResponse_QNAME = new QName("http://ws/", "TodosOsExamesResponse");
    private final static QName _Filtros_QNAME = new QName("http://ws/", "filtros");
    private final static QName _TodosOsExames_QNAME = new QName("http://ws/", "TodosOsExames");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exame }
     * 
     */
    public Exame createExame() {
        return new Exame();
    }

    /**
     * Create an instance of {@link InfoFault }
     * 
     */
    public InfoFault createInfoFault() {
        return new InfoFault();
    }

    /**
     * Create an instance of {@link TodosOsExamesResponse }
     * 
     */
    public TodosOsExamesResponse createTodosOsExamesResponse() {
        return new TodosOsExamesResponse();
    }

    /**
     * Create an instance of {@link Filtros }
     * 
     */
    public Filtros createFiltros() {
        return new Filtros();
    }

    /**
     * Create an instance of {@link TodosOsExames }
     * 
     */
    public TodosOsExames createTodosOsExames() {
        return new TodosOsExames();
    }

    /**
     * Create an instance of {@link Filtro }
     * 
     */
    public Filtro createFiltro() {
        return new Filtro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "exame")
    public JAXBElement<Exame> createExame(Exame value) {
        return new JAXBElement<Exame>(_Exame_QNAME, Exame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ErroIdFault")
    public JAXBElement<InfoFault> createErroIdFault(InfoFault value) {
        return new JAXBElement<InfoFault>(_ErroIdFault_QNAME, InfoFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TodosOsExamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "TodosOsExamesResponse")
    public JAXBElement<TodosOsExamesResponse> createTodosOsExamesResponse(TodosOsExamesResponse value) {
        return new JAXBElement<TodosOsExamesResponse>(_TodosOsExamesResponse_QNAME, TodosOsExamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Filtros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "filtros")
    public JAXBElement<Filtros> createFiltros(Filtros value) {
        return new JAXBElement<Filtros>(_Filtros_QNAME, Filtros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TodosOsExames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "TodosOsExames")
    public JAXBElement<TodosOsExames> createTodosOsExames(TodosOsExames value) {
        return new JAXBElement<TodosOsExames>(_TodosOsExames_QNAME, TodosOsExames.class, null, value);
    }

}
