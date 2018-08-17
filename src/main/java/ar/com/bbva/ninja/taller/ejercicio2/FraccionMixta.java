/**
 * También se puede implementar esta clase como una composición de 
 * un número entero y un objeto de la clase fracción.
 * 
 * @version 1.0
 * @author fernando
 * 
 */

package ar.com.bbva.ninja.taller.ejercicio2;

public class FraccionMixta extends Fraccion {
	protected int entero;
	
	public FraccionMixta(int numerador, int denominador) {
		super(numerador, denominador);
		entero = numerador / denominador;
		this.numerador = numerador % denominador;
		this.denominador = denominador;
	}

	public FraccionMixta(int entero, int numerador, int denominador) {
		super(numerador, denominador);
		this.entero = entero;
		
		// Convierto la fracción mixta en una fracción impropia
		numerador = (entero * denominador) + numerador;
	}
	
	public Fraccion getFraccionImpropia() {
		int numerador = (entero * denominador) + this.numerador;
		return new Fraccion(numerador, denominador);
	}

	@Override
	public String toString() {
		if (numerador < 0 || denominador < 0) {
			return entero + " -" + Math.abs(numerador) + "/" + Math.abs(denominador);
		} else {
			return entero + " " + numerador + "/" + denominador;
		}
	}
}
