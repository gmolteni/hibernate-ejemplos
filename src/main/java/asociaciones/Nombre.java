package asociaciones;

import javax.persistence.*;


@Entity
public class Nombre {
	@Id @GeneratedValue
	long id_nom;
	
	@Basic
	String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_fam", nullable=false)
	private Familia familia;

	public Nombre()          { }
	public Nombre(Familia f) { familia=f; }

	public long getId_nom() {
		return id_nom;
	}
	public void setId_nom(long id_nom) {
		this.id_nom = id_nom;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}	
}
