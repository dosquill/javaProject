package progettoJava;

import java.util.Arrays;
import java.util.Objects;

public class CampoTennis {
	private String tipo;
	private int numero;
	private int[] dim;
	private int costoOrario;
	
	
	// generated constructor
	
	public CampoTennis(String tipo, int numero, int[] dim, int costoOrario) {
		super();
		this.tipo = tipo;
		this.numero = numero;
		this.dim = dim;
		this.costoOrario = costoOrario;
	}

	// overridden methods
	
	@Override
	public String toString() {
		return "CampoTennis [tipo=" + tipo + ", numero=" + numero + ", dim=" + Arrays.toString(dim) + ", costoOrario="
				+ costoOrario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dim);
		result = prime * result + Objects.hash(costoOrario, numero, tipo);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoTennis other = (CampoTennis) obj;
		return costoOrario == other.costoOrario && Arrays.equals(dim, other.dim) && numero == other.numero
				&& Objects.equals(tipo, other.tipo);
	}
	
	
	// getters and setters	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int[] getDim() {
		return dim;
	}
	public void setDim(int[] dim) {
		this.dim = dim;
	}
	public int getCostoOrario() {
		return costoOrario;
	}
	public void setCostoOrario(int costoOrario) {
		this.costoOrario = costoOrario;
	}
	
	
	
	
	
}
