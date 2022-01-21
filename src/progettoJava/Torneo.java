package progettoJava;

import java.util.Date;
import java.util.Objects;

public class Torneo {
	private String categoria;
	private Date data;
	private String citta;
	private String nome;
	private Premio premio;
	private double incassoTotale;
	
	
	// generated constructor
	
	public Torneo(String categoria, Date data, String citta, String nome, Premio premio, double incassoTotale) {
		this.categoria = categoria;
		this.data = data;
		this.citta = citta;
		this.nome = nome;
		this.premio = premio;
		this.incassoTotale = incassoTotale;
	}
	
	// overridden methods
	
	@Override
	public int hashCode() {
		return Objects.hash(categoria, citta, data, incassoTotale, nome, premio);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(citta, other.citta)
				&& Objects.equals(data, other.data)
				&& Double.doubleToLongBits(incassoTotale) == Double.doubleToLongBits(other.incassoTotale)
				&& Objects.equals(nome, other.nome) && Objects.equals(premio, other.premio);
	}
	
	@Override
	public String toString() {
		return "Torneo [categoria=" + categoria + ", data=" + data + ", citta=" + citta + ", nome=" + nome + ", premio="
				+ premio + ", incassoTotale=" + incassoTotale + "]";
	}
	
	
	// getters and setters
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Premio getPremio() {
		return premio;
	}
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	public double getIncassoTotale() {
		return incassoTotale;
	}
	public void setIncassoTotale(double incassoTotale) {
		this.incassoTotale = incassoTotale;
	}
	
	
	
	
}
