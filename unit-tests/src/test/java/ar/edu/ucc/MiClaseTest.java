package ar.edu.ucc;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiClaseTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		MiClase tester = new MiClase();
		assertEquals("1000 / 2 debe ser 500", 500, tester.dividir(100, 5));
	}

	@Test
	public void testMultiply() {
		MiClase tester = new MiClase();
		assertEquals("10 x 5 debe ser 50", 50, tester.dividir(10, 5));
	}
}
