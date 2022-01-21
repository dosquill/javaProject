package progettoJava;

import java.util.Objects;

public class Premio {
	private int posto;
	private double denaro;
	
	
	// constructor
	
	public Premio(int posto, double denaro) {
		super();
		this.posto = posto;
		this.denaro = denaro;
	}

	// overridden methods

	@Override
	public String toString() {
		return "Premio [posto=" + posto + ", denaro=" + denaro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(denaro, posto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		return Double.doubleToLongBits(denaro) == Double.doubleToLongBits(other.denaro) && posto == other.posto;
	}

	// getters and setters

	public int getPosto() {
		return posto;
	}
	public void setPosto(int posto) {
		this.posto = posto;
	}
	public double getDenaro() {
		return denaro;
	}
	public void setDenaro(double denaro) {
		this.denaro = denaro;
	}
	
	
}
