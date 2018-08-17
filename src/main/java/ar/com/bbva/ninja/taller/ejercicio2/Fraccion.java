/**
 * Implementación de una clase para manejar objetos de tipo fracción.
 * 
 * @version 1.0
 * @author fernando
 * 
 */

package ar.com.bbva.ninja.taller.ejercicio2;

public class Fraccion {
	protected int numerador;
	protected int denominador;
	
	public Fraccion(int numerador, int denominador) {

		if (denominador == 0 || numerador == 0) {
			throw new IllegalArgumentException("Ni el numerador ni el denominador pueden ser cero.");
		} else {
			this.numerador = numerador;
			this.denominador = denominador;
		}
	}
	
	public Fraccion sumar(Fraccion f) {
		int numerador = 0;
		int denominador = 0;
		int mcm = 0;
		
		if (this.denominador == f.denominador) {
			denominador = this.denominador;
			numerador = this.numerador + f.numerador;
		} else {
			// Distinto denominador: método de M.C.M (Mínimo Común Múltiplo)
			mcm = mcm(this.denominador, f.denominador);
			denominador = mcm;
			numerador = this.numerador * mcm + f.numerador * mcm;
		}
		return new Fraccion(numerador, denominador).reducir();
	}
	
	public Fraccion restar(Fraccion f) {
		int numerador = 0;
		int denominador = 0;
		
		if (this.denominador == f.denominador) {
			numerador = this.numerador - f.numerador;
			denominador = this.denominador;
		} else {
			numerador = ((this.numerador * f.denominador) - (f.numerador * this.denominador));
			denominador = this.denominador * f.denominador;
		}
		
		return new Fraccion(numerador, denominador).reducir();
	}
	
	public Fraccion multiplicar(Fraccion f) {
		int numerador = this.numerador * f.numerador;
		int denominador = this.denominador * f.denominador;
		return new Fraccion(numerador, denominador).reducir();
	}
	
	/**
	 * Método sobrecargado para multiplicar una fracción por cualquier entero.
	 * @param n
	 * @return
	 */
	public Fraccion multiplicar(int n) {
		return multiplicar(new Fraccion(n, 1));
	}
	
	public Fraccion dividir(Fraccion f) {
		int numerador = this.numerador * f.denominador;
		int denominador = this.denominador * f.numerador;
		System.out.println(numerador + "/" + denominador);
		return new Fraccion(numerador, denominador).reducir();
	}
	
	private Fraccion reducir() {
		if (this.numerador == this.denominador)
			return new Fraccion(1, 1);
		
		int mcd = mcd(this.numerador, this.denominador);
		return new Fraccion((this.numerador / mcd), (this.denominador / mcd));
	}
	
	public double getEnDecimal() {
		return (double)this.numerador / (double)this.denominador;
	}
	
	/**
	 * Cuando la fracción es negativa, para considerar la igualdad con respecto a otra, 
	 * no me importa si es el numerador o el denominador quien tiene el símbolo negativo.
	 * Al comparar se aplica la regla de los signos.
	 * 
	 * Ej.: 
	 * 		Fraccion(1, 3)  "es igual que" Fraccion(-1, -3)
	 * 		Fraccion(1, -3) "es igual que" Fraccion(-1, 3)
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		int signo1 = this.numerador * this.denominador;
		int signo2 = ((Fraccion)obj).numerador * ((Fraccion)obj).denominador;
		
		return Math.abs(this.numerador) == Math.abs(((Fraccion)obj).numerador) && 
				Math.abs(this.denominador) == Math.abs(((Fraccion)obj).denominador) &&
				((signo1 > 0 && signo2 > 0 || signo1 < 0 && signo2 < 0)); 
	}

	@Override
	public String toString() {
		if (numerador < 0 || denominador < 0) {
			return "-" + Math.abs(numerador) + "/" + Math.abs(denominador);
		} else {
			return numerador + "/" + denominador;
		}
	}
	
	/**
	 * Método para calcular el Mínimo Común Múltiplo
	 * @param num1 primer número
	 * @param num2 segundo número
	 * @return mcm que es el Mínimo Común Múltiplo entre num1 y num2
	 * 
	 * Gentileza de: http://www.eljavatar.com/2014/05/Como-Hallar-el-Minimo-Comun-Multiplo-en-Java.html
	 */
	
	private int mcm(int num1, int num2) {
		int mcm = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		
		mcm = (a / mcm(a, b)) * b;
		return mcm;
	}
	
	/**
	 * Método para calcular el Máximo Común Divisor
	 * @param num1 primer número
	 * @param num2 segundo número
	 * @return mcd que es el Máximo Común Divisor entre num1 y num2
	 * 
	 * Gentileza de: http://www.eljavatar.com/2014/05/Como-Hallar-el-Minimo-Comun-Multiplo-en-Java.html
	 */
	
	private int mcd(int num1, int num2) {
		int mcd = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		
		do {
			mcd = b;
			b = a % b;
			a = mcd;
		} while (b != 0);
		
		return mcd;
	}
}
