package simple;
import javax.persistence.*;


@Entity
public class Palabras {

	@Id @GeneratedValue
	long id;
	@Basic
	String palabra;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	
}
