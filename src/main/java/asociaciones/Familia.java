package asociaciones;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Familia {
		
		@Id @GeneratedValue
		long id_fam;
		
		@Basic
		String nombreFamilia;
		
		@OneToMany
	    private List<Nombre> nombres;
		
		
		
		
		
		public long getId_fam() {
			return id_fam;
		}
		public void setId_fam(long id_fam) {
			this.id_fam = id_fam;
		}
		public List<Nombre> getNombres() {
			return nombres;
		}
		public void setNombres(List<Nombre> nombres) {
			this.nombres = nombres;
		}
		public String getNombreFamilia() {
			return nombreFamilia;
		}
		public void setNombreFamilia(String nombreFamilia) {
			this.nombreFamilia = nombreFamilia;
		}
		@Override
		public String toString() {
			String ini = "Familia [nombreFamilia=" + nombreFamilia + ", nombres=";
			for (Nombre e:nombres)
			{
				ini+=e.getNombre()+" ";
			}						
			ini+="]";
			return ini;
		}
	
}

