package progettoJava;

import java.util.Objects;

public class Tennista {
	private String codFis;
	private String nome;
	private String cognome;
	private long tessera;
	private int anno;
	private String racchetta;
	
	
	
	// constructor
	public Tennista(String codFis, String nome, String cognome, long tessera, int anno, String racchetta) {
		this.codFis = codFis;
		this.nome = nome;
		this.cognome = cognome;
		this.tessera = tessera;
		this.anno = anno;
		this.racchetta = racchetta;
	}
	
	// overriden methods
	
	@Override
	public String toString() {
		return "Tennista [codFis=" + codFis + ", nome=" + nome + ", cognome=" + cognome + ", tessera=" + tessera
				+ ", anno=" + anno + ", racchetta=" + racchetta + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(anno, codFis, cognome, nome, racchetta, tessera);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tennista other = (Tennista) obj;
		return anno == other.anno && Objects.equals(codFis, other.codFis) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(nome, other.nome) && Objects.equals(racchetta, other.racchetta)
				&& tessera == other.tessera;
	}
	
	
	// getters and setters
	public String getCodFis() {
		return codFis;
	}
	public void setCodFis(String codFis) {
		this.codFis = codFis;
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
	public long getTessera() {
		return tessera;
	}
	public void setTessera(long tessera) {
		this.tessera = tessera;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getRacchetta() {
		return racchetta;
	}
	public void setRacchetta(String racchetta) {
		this.racchetta = racchetta;
	}
	
	
	
	
}
