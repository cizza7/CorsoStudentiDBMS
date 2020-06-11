package bean;

public class Corso {

	private int idCorso;
	private String nomeCorso;
	private String materiaCorso;
	private String sedeCorso;
	private int numeroCrediti;
	
	
	public Corso() {}

	public Corso(String nomeCorso, String materiaCorso, String sedeCorso, int numeroCrediti) {
		this.nomeCorso = nomeCorso;
		this.materiaCorso = materiaCorso;
		this.sedeCorso = sedeCorso;
		this.numeroCrediti = numeroCrediti;
	}

	public Corso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}


	public int getIdCorso() {
		return idCorso;
	}


	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}


	public String getNomeCorso() {
		return nomeCorso;
	}


	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}


	public String getMateriaCorso() {
		return materiaCorso;
	}


	public void setMateriaCorso(String materiaCorso) {
		this.materiaCorso = materiaCorso;
	}


	public String getSedeCorso() {
		return sedeCorso;
	}


	public void setSedeCorso(String sedeCorso) {
		this.sedeCorso = sedeCorso;
	}


	public int getNumeroCrediti() {
		return numeroCrediti;
	}


	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}



	@Override
	public String toString() {
		return "Codice corso:" + idCorso + "\n" + "Nome del Corso:" + nomeCorso + "\n" + "Materia:" + materiaCorso
				+ "\n" + "Sede:" + sedeCorso + "\n" + "Numero di Crediti: " + numeroCrediti + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;

		if (nomeCorso == null) {
			if (other.nomeCorso != null)
				return false;
		} else if (!nomeCorso.equals(other.nomeCorso))
			return false;
		if (idCorso != other.idCorso)
			return false;
		if (materiaCorso == null) {
			if (other.materiaCorso != null)
				return false;
		} else if (!materiaCorso.equals(other.materiaCorso))
			return false;
		if (numeroCrediti != other.numeroCrediti)
			return false;
		if (sedeCorso == null) {
			if (other.sedeCorso != null)
				return false;
		} else if (!sedeCorso.equals(other.sedeCorso))
			return false;
		return true;
	}
	
	
	
	
	

}
