package org.iesalandalus.programacion.torreajedrez;

public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		Torre TorreNegra = new Torre();
	}
	private static void mostrarTorre() {
		try {
            System.out.println(torre.toString());
        } catch (NullPointerException t) {
            System.out.println("ERROR: La torre no se ha creado.");
        }
	}
	
}
