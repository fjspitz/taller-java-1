/**
 * Conceptos:
 * 
 * 1. Tipos primitivos. Tipos referenciados.
 * 2. Clases y objetos: declaración, instanciación, inicialización.
 * 3. El método constructor. Diferentes constructores.
 * 4. Herencia
 * 5. Propiedades, atributos, mensajes, métodos, variables y ámbitos
 * 6. Sobrecarga y sobreescritura de métodos.
 * 7. Polimorfismo.
 * 8. Encapsulación.
 * 9.  
 * 
 * @version 1.0
 * @author fernando
 * 
 */

package ar.com.bbva.ninja.taller.ejercicio2;

public class Main {
	
	// FIXME: rehacer este método
	public static void main(String[] args) {
		Fraccion f1 = new Fraccion(1, 3);
		Fraccion f2 = new Fraccion(2, 3);
		
		Fraccion f3 = f1.sumar(f2);
		Fraccion f4 = f1.restar(f2);
		
		Fraccion f5 = new Fraccion(-1, -3);
		Fraccion f6 = new Fraccion(1, 3);
		
		Fraccion f7 = new Fraccion(4, 8);
		Fraccion f8 = new Fraccion(15, 9);
		Fraccion f9 = new Fraccion(3, 6);
		Fraccion f10 = new Fraccion(4, 5);
		Fraccion f11 = new Fraccion(3, 9);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		
		System.out.println(f1.getEnDecimal());
		System.out.println(f2.getEnDecimal());
		System.out.println(f3.getEnDecimal());
		System.out.println(f4.getEnDecimal());
		
		System.out.println("Comparando fracciones: " + f5.equals(f6));
		System.out.println("Multiplicando fracciones: " + f5.multiplicar(f6));
		System.out.println("Multiplicando fracciones: " + f7.multiplicar(f8));
		System.out.println("Multiplicando una fraccion por un entero: " + f9.multiplicar(7));
		System.out.println("Multiplicando una fraccion por un entero negativo: " + f9.multiplicar(-7));
		System.out.println("Dividiendo entre fracciones: " + f10.dividir(f11));
		
		// TODO: revisar el tema de los negativos con los mixtos.
		FraccionMixta fm1 = new FraccionMixta(8, 1, 4);
		System.out.println(fm1);
		
		System.out.println(fm1.getFraccionImpropia());
		
	}
}
