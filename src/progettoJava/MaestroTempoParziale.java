package progettoJava;

import java.util.Objects;

public class MaestroTempoParziale extends Maestro{
	private String tipoContratto;
	private int mesiPrevisti;
	
	
	// generated constructor
	public MaestroTempoParziale(String matricolaConi, String nome, String cognome, String via, int cap, String citta,
			String certificazione, int costoOrario, String tipoContratto, int mesiPrevisti) {
		super(matricolaConi, nome, cognome, via, cap, citta, certificazione, costoOrario);
		this.tipoContratto = tipoContratto;
		this.mesiPrevisti = mesiPrevisti;
	}
	
	// overridden methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mesiPrevisti, tipoContratto);
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
		MaestroTempoParziale other = (MaestroTempoParziale) obj;
		return mesiPrevisti == other.mesiPrevisti && Objects.equals(tipoContratto, other.tipoContratto);
	}
	@Override
	public String toString() {
		return "MaestroTempoParziale [tipoContratto=" + tipoContratto + ", mesiPrevisti=" + mesiPrevisti + "]";
	}

	
	// getters and setters
	public String getTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	public int getMesiPrevisti() {
		return mesiPrevisti;
	}

	public void setMesiPrevisti(int mesiPrevisti) {
		this.mesiPrevisti = mesiPrevisti;
	}
	
	
	
	
	
}
