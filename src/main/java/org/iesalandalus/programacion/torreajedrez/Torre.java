package org.iesalandalus.programacion.torreajedrez;

public class Torre{
	private Color Color;
	private Posicion Posicion;
	private void setColor(Color color) {
		if (Color == null) {
			throw new NullPointerException("Error: No se puede definir ese color");
		}else {
			this.Color = color;
		}
	}
	private void setPosicion(Posicion posicion) {
		new Posicion(this.Posicion);
	}
	public Color getColor() {
		return Color;
	}
	public Posicion getPosicion() {
		return Posicion;
	}
}
