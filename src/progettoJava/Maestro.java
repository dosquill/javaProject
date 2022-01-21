package progettoJava;

import java.util.Date;
import java.util.Objects;

public abstract class Maestro {
	private String matricolaConi;
	private String nome;
	private String cognome;
	private String via;
	private int cap;
	private String citta;
	private String certificazione;
	private int costoOrario;
	
	
	
	// generated constructor
	public Maestro(String matricolaConi, String nome, String cognome, String via, int cap, String citta,
			String certificazione, int costoOrario) {
		this.matricolaConi = matricolaConi;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.certificazione = certificazione;
		this.costoOrario = costoOrario;
	}

	// overridden methods
	@Override
	public String toString() {
		return "Maestro [matricolaConi=" + matricolaConi + ", nome=" + nome + ", cognome=" + cognome + ", via=" + via
				+ ", cap=" + cap + ", citta=" + citta + ", certificazione=" + certificazione + ", costoOrario="
				+ costoOrario + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cap, certificazione, citta, cognome, costoOrario, matricolaConi, nome, via);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maestro other = (Maestro) obj;
		return cap == other.cap && Objects.equals(certificazione, other.certificazione)
				&& Objects.equals(citta, other.citta) && Objects.equals(cognome, other.cognome)
				&& costoOrario == other.costoOrario && Objects.equals(matricolaConi, other.matricolaConi)
				&& Objects.equals(nome, other.nome) && Objects.equals(via, other.via);
	}

	// getters and setters
	public String getMatricolaConi() {
		return matricolaConi;
	}
	public void setMatricolaConi(String matricolaConi) {
		this.matricolaConi = matricolaConi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCertificazione() {
		return certificazione;
	}
	public void setCertificazione(String certificazione) {
		this.certificazione = certificazione;
	}
	public int getCostoOrario() {
		return costoOrario;
	}
	public void setCostoOrario(int costoOrario) {
		this.costoOrario = costoOrario;
	}
	
	

	
	
	
}
