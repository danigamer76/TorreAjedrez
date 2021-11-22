package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

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
	private static void mostrarMenu() {
		System.out.println("MENU TORRE");
		System.out.println("1.Crear Torre por Defecto");
		System.out.println("2.Crear Torre por Color");
		System.out.println("3.Crear Torre de un Color y Columna Inicial");
		System.out.println("4.Mover Peon");
		System.out.println("5.Salir");
	}
	private static int elegirOpcion() {
		int eleccion = 0;
		System.out.println("ELIGE LA OPCION:");
		do {
			eleccion = Entrada.entero();
			if(eleccion>5 || eleccion<1) {
				System.out.println("OPCION NO VALIDA");
			}
		}while(eleccion>5 || eleccion<1);
		return eleccion;
	}
	private static char elegirColumnaInicial() {
		char columna;
		do {
			columna = Entrada.caracter();
			if(columna>'h' || columna<'a') {
				System.out.println("COLUMNA NO VALIDA");
			}
		}while(columna>'h' || columna<'a');
		return columna;
		
	}
	private static void mostrarMenuDirecciones() {
		System.out.println("MENU DIRECCIONES");
		System.out.println("1.Arriba");
		System.out.println("2.Derecha");
		System.out.println("3.Izquierda");
		System.out.println("4.Abajo");
		System.out.println("5.Salir");
	}
	
}
