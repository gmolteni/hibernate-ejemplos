package asociacionesmap;

import javax.persistence.*;

import asociaciones.Familia;


@Entity
public class XNombre {
	@Id
	String nombre;
	
	@Basic
	Integer edad;
	
	private Familia familia;

	public XNombre()          { }
	public XNombre(Familia f) { familia=f; }

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}
