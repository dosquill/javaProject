package progettoJava;

import java.util.Objects;

public class Lezione {
	private int costoOrario;
	private int numPartecipanti;
	private String codice;
	
	
	// generated constructor
	
	public Lezione(int costoOrario, int numPartecipanti, String codice) {
		this.costoOrario = costoOrario;
		this.numPartecipanti = numPartecipanti;
		this.codice = codice;
	}

	// overridden methods
	
	@Override
	public String toString() {
		return "Lezione [costoOrario=" + costoOrario + ", numPartecipanti=" + numPartecipanti + ", codice=" + codice
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, costoOrario, numPartecipanti);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lezione other = (Lezione) obj;
		return Objects.equals(codice, other.codice) && costoOrario == other.costoOrario
				&& numPartecipanti == other.numPartecipanti;
	}
	
	// getters and setters
	
	public int getCostoOrario() {
		return costoOrario;
	}
	public void setCostoOrario(int costoOrario) {
		this.costoOrario = costoOrario;
	}
	public int getNumPartecipanti() {
		return numPartecipanti;
	}
	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
}
