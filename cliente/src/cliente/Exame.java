
package cliente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exame complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exame">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomeExame" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exame", propOrder = {
    "id",
    "nomeExame"
})
public class Exame {

    protected int id;
    @XmlElement(required = true)
    protected String nomeExame;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade nomeExame.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeExame() {
        return nomeExame;
    }

    /**
     * Define o valor da propriedade nomeExame.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeExame(String value) {
        this.nomeExame = value;
    }

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nomeExame=" + nomeExame + "]";
	}
    
}
