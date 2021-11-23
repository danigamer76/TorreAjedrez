package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		int elegir;
		do {
			mostrarMenu();
			elegir = elegirOpcion();
			ejecutarOpcion(elegir);
		}while(elegir != 5);
	}
	private static void mostrarTorre() {
		try {
			System.out.println("-------------------------");
			System.out.println(torre.toString());
			System.out.println("-------------------------");
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
		int eleccion;
		System.out.println("ELIGE LA OPCION:");
		do {
			eleccion = Entrada.entero();
			if(eleccion>5 || eleccion<1) {
				System.out.println("OPCION NO VALIDA");
			}
		}while(eleccion>5 || eleccion<1);
		return eleccion;
	}
	private static Color elegirColor() {
		Color color = null;
		int eleccion = 0;
		System.out.println("ELEGIR COLOR: \n1. NEGRO \n2.BLANCO");
		do {
			eleccion = Entrada.entero();
				switch (eleccion) {
				case 1:
					color = Color.NEGRA;
					break;

				case 2:
					color = Color.BLANCA;
					break;
				}
				if(color != Color.BLANCA && color != Color.NEGRA) {
					System.out.println("OPCION NO VALIDA");
				}
			
		}while(color != Color.BLANCA && color != Color.NEGRA);
		return color;
	}
	private static char elegirColumnaInicial() {
		char columna;
		System.out.println("ELIGE LA COLUMNA INICIAL (A|H)");
		do {
			columna = Character.toLowerCase(Entrada.caracter());
			if(columna != 'h' && columna !='a') {
				System.out.println("COLUMNA NO VALIDA");
			}
		}while(columna != 'h' && columna != 'a');
		return columna;

	}
	private static void mostrarMenuDirecciones() {
		System.out.println("MENU DIRECCIONES");
		System.out.println("1.Arriba");
		System.out.println("2.Derecha");
		System.out.println("3.Izquierda");
		System.out.println("4.Abajo");
		System.out.println("5.Enroque Corto");
		System.out.println("6.Enroque Largo");
	}
	private static Direccion elegirDireccion() {
		Direccion direccion = Direccion.ABAJO;
		int eleccion;
		System.out.println("ELIGE LA OPCION:");
		do {
			eleccion = Entrada.entero();
			if(eleccion>6 || eleccion<1) {
				System.out.println("OPCION NO VALIDA");
			}
		}while(eleccion>6 || eleccion<1);
		switch (eleccion) {
		case 1:
			direccion = Direccion.ARRIBA;
			break;
		case 2:
			direccion = Direccion.DERECHA;
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			break;
		case 4:
			direccion = Direccion.ABAJO;
			break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
			break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
			break;
		}
		return direccion;
	}
	private static void crearTorreDefecto() {
		torre = new Torre();
	}
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}
	private static void mover() {
		mostrarMenuDirecciones();
		Direccion direccion = elegirDireccion();
		if(direccion == Direccion.ENROQUE_CORTO || direccion == Direccion.ENROQUE_LARGO) {
			try {
				torre.enrocar(direccion);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("INTRODUCE EL NUMERO DE PASOS:");
			int pasos = Entrada.entero();
			try {
				torre.mover(direccion, pasos);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	private static void ejecutarOpcion(int opcion)  {
		switch (opcion) {
		case 1:
			crearTorreDefecto();
			mostrarTorre();
			break;
		case 2:
			crearTorreColor();
			mostrarTorre();
			break;
		case 3:
			crearTorreColorColumna();
			mostrarTorre();
			break;
		case 4:
			mover();
			mostrarTorre();
			break;
		case 5:
			System.out.println("Hasta Pronto...");
			break;
		}

	}
}
