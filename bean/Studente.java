package bean;

public class Studente {
	
	private int idStudente;
	private String nomeStudente;
	private String cognomeStudente;
	private int annoDiNascita;
	
	
	public Studente() {}


	public int getIdStudente() {
		return idStudente;
	}


	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}


	public String getNomeStudente() {
		return nomeStudente;
	}


	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}


	public String getCognomeStudente() {
		return cognomeStudente;
	}


	public void setCognomeStudente(String cognomeStudente) {
		this.cognomeStudente = cognomeStudente;
	}


	public int getAnnoDiNascita() {
		return annoDiNascita;
	}


	public void setAnnoDiNascita(int annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (annoDiNascita != other.annoDiNascita)
			return false;
		if (cognomeStudente == null) {
			if (other.cognomeStudente != null)
				return false;
		} else if (!cognomeStudente.equals(other.cognomeStudente))
			return false;
		if (idStudente != other.idStudente)
			return false;
		if (nomeStudente == null) {
			if (other.nomeStudente != null)
				return false;
		} else if (!nomeStudente.equals(other.nomeStudente))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Codice Studente: " + idStudente + "\n"
				+ "Nome: " + nomeStudente+ "\n"
						+ "Cognome: " + cognomeStudente + "\n"
								+ "Anno di nascita: " + annoDiNascita + "\n";
	}
	
	
	
}
