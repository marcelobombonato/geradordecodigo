import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "VISAO_PERF")
public class VisaoPerformance implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID_VISAO") 
		private Integer idVisaoPerformance


		@Column(name="NOME_VISAO") 
		private String nomeVisao

		@Column(name="DATA_CRI_VISAO") 
		private Date dataCriacaoVisao

		public String getNomeVisao() {
			return nomeVisao;
		}

		public void setNomeVisao(String nomeVisao) {
			this.nomeVisao = nomeVisao;
		}

		public Date getDataCriacaoVisao() {
			return dataCriacaoVisao;
		}

		public void setDataCriacaoVisao(Date dataCriacaoVisao) {
			this.dataCriacaoVisao = dataCriacaoVisao;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idVisaoPerformance == null) ? 0 : idVisaoPerformance.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VisaoPerformance other = (VisaoPerformance) obj;
			if (idVisaoPerformance == null) {
				if (other.idVisaoPerformance != null)
					return false;
				} else if (!idVisaoPerformance.equals(other.idVisaoPerformance))
					return false;
				return true;
		}
}
