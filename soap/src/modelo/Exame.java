package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Exame {
	
	@XmlElement(required=true)
	Integer id;
	@XmlElement(required=true)
	String nomeExame;
	
	public Exame() {
		super();
	}

	public Exame(String nomeExame) {
		super();
		this.nomeExame = nomeExame;
	}
	
	public Exame(Integer id, String nomeExame) {
		super();
		this.id = id;
		this.nomeExame = nomeExame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nomeExame=" + nomeExame + "]";
	}
	
}
