package progettoJava;

import java.util.Date;
import java.util.Objects;

public class MaestroTempoPieno extends Maestro {
	private int minOreAnnue;
	private double stipendioMensile;
	private Date dataAssunzione;
	
	// generated constructor
	public MaestroTempoPieno(String matricolaConi, String nome, String cognome, String via, int cap, String citta,
			String certificazione, int costoOrario, int minOreAnnue, double stipendioMensile, Date dataAssunzione) {
		super(matricolaConi, nome, cognome, via, cap, citta, certificazione, costoOrario);
		this.minOreAnnue = minOreAnnue;
		this.stipendioMensile = stipendioMensile;
		this.dataAssunzione = dataAssunzione;
	}

	// overridden methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataAssunzione, minOreAnnue, stipendioMensile);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaestroTempoPieno other = (MaestroTempoPieno) obj;
		return Objects.equals(dataAssunzione, other.dataAssunzione) && minOreAnnue == other.minOreAnnue
				&& Double.doubleToLongBits(stipendioMensile) == Double.doubleToLongBits(other.stipendioMensile);
	}

	@Override
	public String toString() {
		return "MaestroTempoPieno [minOreAnnue=" + minOreAnnue + ", stipendioMensile=" + stipendioMensile
				+ ", dataAssunzione=" + dataAssunzione + "]";
	}

	
	// getters and setters
	public int getMinOreAnnue() {
		return minOreAnnue;
	}

	public void setMinOreAnnue(int minOreAnnue) {
		this.minOreAnnue = minOreAnnue;
	}

	public double getStipendioMensile() {
		return stipendioMensile;
	}

	public void setStipendioMensile(double stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	
	
	
	
	
}
