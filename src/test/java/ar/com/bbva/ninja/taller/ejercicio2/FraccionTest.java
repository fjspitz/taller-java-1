package ar.com.bbva.ninja.taller.ejercicio2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class FraccionTest {
	
	@Test
	public void crearUnaFraccionConDosNumerosPositivos() {
		Fraccion fraccion = new Fraccion(3, 4);
		assertNotNull("No se pudo crear la fracción con los números 3 y 4", fraccion);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void crearUnaFraccionConNumeradorCero() {
		new Fraccion(0, 3);
		//assertThat("No se puede crear una fracción con numerador cero", fraccion, is(new Fraccion(0, 0)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void crearUnaFraccionConDenominadorCero() {
		new Fraccion(6, 0);
		//assertThat("No se puede crear una fracción con denominador cero", fraccion, is(new Fraccion(0, 0)));
	}
	
	@Test
	public void crearUnaFraccionConDosNumerosPositivosAleatorios() {
		Fraccion fraccion = new Fraccion(3, 4);
		assertNotNull("No se pudo crear la fracción con los números 3 y 4", fraccion);
	}
	
	@Test
	public void sumarDosFraccionesConMismoDenominador() {
		Fraccion f1 = new Fraccion(2, 4);
		Fraccion f2 = new Fraccion(1, 4);
		Fraccion expected = new Fraccion(3, 4);
		
		Fraccion resultado = f1.sumar(f2);
		assertThat("", resultado, is(expected));
	}
}
