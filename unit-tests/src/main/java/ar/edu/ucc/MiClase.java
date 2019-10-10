package ar.edu.ucc;

import org.junit.Test;

public class MiClase {
	
	public int dividir(int x, int y) {
		if (x >= 100) {
			throw new IllegalArgumentException("X debe ser menor a 1000");
		}
		return x / y;
	}
}
