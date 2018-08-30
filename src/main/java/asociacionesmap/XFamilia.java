package asociacionesmap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

@Entity
public class XFamilia {
		
		@Id @GeneratedValue
		long id_fam;
		
		@Basic
		String nombreFamilia;
		
		@OneToMany
		@MapKey (name="id")
	    private Map<XNombre,Integer> nombres;
				
		
		public long getId_fam() {
			return id_fam;
		}





		public void setId_fam(long id_fam) {
			this.id_fam = id_fam;
		}





		public String getNombreFamilia() {
			return nombreFamilia;
		}

		public void setNombreFamilia(String nombreFamilia) {
			this.nombreFamilia = nombreFamilia;
		}

		public Map<XNombre, Integer> getNombres() {
			return nombres;
		}

		public void setNombres(Map<XNombre, Integer> nombres) {
			this.nombres = nombres;
		}

		@Override
		public String toString() {
			return "XFamilia [id_fam=" + id_fam + ", nombreFamilia=" + nombreFamilia + ", nombres=" + nombres + "]";
		}	
}

