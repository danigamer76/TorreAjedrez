package org.iesalandalus.programacion.torreajedrez;

public class Torre{
	private Color Color;
	private Posicion Posicion;
	
	public Torre() {
		setColor(Color.NEGRO);;
		setPosicion(new Posicion(8, 'h'));
	}
	
	public Torre(Color Color) {
		if (Color == Color.NEGRO) {
			setColor(Color.NEGRO);;
			setPosicion(new Posicion(8, 'h'));
		}else {
			setColor(Color.BLANCO);;
			setPosicion(new Posicion(1, 'h'));
		}

	}
	
	public Torre(Color Color, char columna) {
		if (Color == Color.NEGRO) {
			setColor(Color.NEGRO);;
			setPosicion(new Posicion(8, columna));
		}else {
			setColor(Color.BLANCO);;
			setPosicion(new Posicion(1, columna));
		}
	}
	
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
