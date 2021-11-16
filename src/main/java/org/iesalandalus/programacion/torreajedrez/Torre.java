package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre{
	private Color Color;
	private Posicion Posicion;

	public Torre() {
		setColor(Color.NEGRO);;
		setPosicion(new Posicion(8, 'h'));
	}

	public Torre(Color Color) {
		if (Color.equals(Color.NEGRO)) {
			setColor(Color.NEGRO);;
			setPosicion(new Posicion(8, 'h'));
		}else {
			setColor(Color.BLANCO);;
			setPosicion(new Posicion(1, 'h'));
		}

	}

	public Torre(Color Color, char columna) {
		if (Color.equals(Color.NEGRO)) {
			setColor(Color.NEGRO);;
			setPosicion(new Posicion(8, columna));
		}else {
			setColor(Color.BLANCO);;
			setPosicion(new Posicion(1, columna));
		}
	}

	private void setColor(Color color) {
		if (color.equals(null)) {
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

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if(this.Color.equals(Color.BLANCO)) {
			if(pasos < 0) {
				throw new IllegalArgumentException("Pasos invalidos");
			}else {
				switch (direccion) {
				case ARRIBA:
					if (this.Posicion.getFila()+pasos > 8) {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila()+pasos,this.Posicion.getColumna()));
					}
					break;
				case ABAJO:
					if (this.Posicion.getFila()-pasos < 1) {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila()-pasos,this.Posicion.getColumna()));
					}
					break;
				case IZQUIERDA:
					if (this.Posicion.getColumna()-pasos < 'a') {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila(),(char) (this.Posicion.getColumna()-pasos)));
					}
					break;
				case DERECHA:
					if (this.Posicion.getFila()+pasos > 'h') {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila(),(char) (this.Posicion.getColumna()+pasos)));
					}
					break;
				default:
					throw new NullPointerException("Direccion Nula");
				}
			}
		}else {
			if(pasos < 0) {
				throw new IllegalArgumentException("Pasos invalidos");
			}else {
				switch (direccion) {
				case ABAJO:
					if (this.Posicion.getFila()+pasos > 8) {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila()+pasos,this.Posicion.getColumna()));
					}
					break;
				case ARRIBA:
					if (this.Posicion.getFila()-pasos < 1) {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila()-pasos,this.Posicion.getColumna()));
					}
					break;
				case DERECHA:
					if (this.Posicion.getColumna()-pasos < 'a') {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila(),(char) (this.Posicion.getColumna()-pasos)));
					}
					break;
				case IZQUIERDA:
					if (this.Posicion.getFila()+pasos > 'h') {
						throw new OperationNotSupportedException("Movimiento Invalido");
					}else {
						setPosicion(new Posicion(this.Posicion.getFila(),(char) (this.Posicion.getColumna()+pasos)));
					}
					break;
				default:
					throw new NullPointerException("Direccion Nula");
				}
			}
		}
	}

	public void enroque(Direccion direccion) {
		//NO SE DEBERIA CONTROLAR LA POSICION DEL REY YA QUE DE ESO SE ENCARGARIA LA CLASE ReyAjedrez
		if(Color.equals(Color.BLANCO)){
			if(direccion.equals(Direccion.ENROQUE_CORTO)) {
//				try {
					if(Posicion.getFila() == 1 && Posicion.getColumna() == 'f') {
						setPosicion(new Posicion(1, 'h'));
					}else {
						System.out.println("LA TORRE NO ESTA EN POSICION DE ENROQUE");
					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
			}else if(direccion.equals(Direccion.ENROQUE_LARGO)) {
//				try {
					if(Posicion.getFila() == 1 && Posicion.getColumna() == 'd') {
						setPosicion(new Posicion(1, 'a'));
					}else {
						System.out.println("LA TORRE NO ESTA EN POSICION DE ENROQUE");
					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
			}
		}else if(Color.equals(Color.NEGRO)){
			if(direccion.equals(Direccion.ENROQUE_CORTO)) {
//				try {
					if(Posicion.getFila() == 8 && Posicion.getColumna() == 'f') {
						setPosicion(new Posicion(8, 'h'));
					}else {
						System.out.println("LA TORRE NO ESTA EN POSICION DE ENROQUE");
					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
			}else if(direccion.equals(Direccion.ENROQUE_LARGO)) {
//				try {
					if(Posicion.getFila() == 8 && Posicion.getColumna() == 'd') {
						setPosicion(new Posicion(8, 'a'));
					}else {
						System.out.println("LA TORRE NO ESTA EN POSICION DE ENROQUE");
					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
			}
		}
	}
}
