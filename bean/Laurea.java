package bean;

public class Laurea {

	private int idLaurea;
	private String nomeLaurea;
	private String titoloLaurea;
	private int durataLaurea;
	
	
	public Laurea() {}


	public int getIdLaurea() {
		return idLaurea;
	}


	public void setIdLaurea(int idLaurea) {
		this.idLaurea = idLaurea;
	}


	public String getNomeLaurea() {
		return nomeLaurea;
	}


	public void setNomeLaurea(String nomeLaurea) {
		this.nomeLaurea = nomeLaurea;
	}


	public String getTitoloLaurea() {
		return titoloLaurea;
	}


	public void setTitoloLaurea(String titoloLaurea) {
		this.titoloLaurea = titoloLaurea;
	}


	public int getDurataLaurea() {
		return durataLaurea;
	}


	public void setDurataLaurea(int durataLaurea) {
		this.durataLaurea = durataLaurea;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laurea other = (Laurea) obj;
		if (durataLaurea != other.durataLaurea)
			return false;
		if (idLaurea != other.idLaurea)
			return false;
		if (nomeLaurea == null) {
			if (other.nomeLaurea != null)
				return false;
		} else if (!nomeLaurea.equals(other.nomeLaurea))
			return false;
		if (titoloLaurea == null) {
			if (other.titoloLaurea != null)
				return false;
		} else if (!titoloLaurea.equals(other.titoloLaurea))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Codice Laurea:" + idLaurea + "\n"
				+ "Titolo: " + nomeLaurea + "\n"
						+ "Titolo Ufficiale" + titoloLaurea+ "\n"
								+ "Anni richiesti" + durataLaurea + "\n";
	}
	
	
	
}
