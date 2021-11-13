package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;
	
		public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
		public Posicion(Posicion objPosicion) {
			setFila(objPosicion.fila);
			setColumna(objPosicion.columna);
		}
		
		
	private void setFila(int fila) {
		try {
			if (fila >= 1 && fila <= 8) {
				this.fila = fila;
			}else {
				throw new Exception("Error de fila");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	private void setColumna(char columna) {
		columna = Character.toLowerCase(columna);
		try {
			if (columna >= 'a' &&  columna <= 'h') {
				this.columna = columna;
			}else {
				throw new Exception("Error de columna");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	public int getFila() {
		return fila;
	}
	public char getColumna() {
		return columna;
	}
	
	
}
