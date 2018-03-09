package mundo;

import java.io.Serializable;

public class Jugador implements Serializable{

	//Atributos
	private Jugador anterior;
	private Jugador siguiente;
	private String nombre;
	protected String password;
	private boolean conectado;
	private double nivelActual;
	private double puntajeActual;
	
	
	public boolean isConectado() {
		return conectado;
	}

	/**
	 * <br>Metodo que inicializa los atributos de la clase Jugador</br>
	 * <br>post: Se han inicializado los atributos de la clase Jugador</br>
	 */
	public Jugador(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
		this.nivelActual = 1;
		this.puntajeActual = 0;
		conectado = false;
	}
	
	/**
	 * Este metodo se encargar de verificar los invariantes de la clase Juego
	 * <br>pre: anterior != null</br>
	 * <br>pre: siguiente != null</br>
	 * <br>pre: nombre != null && !nombre.equals("")</br>
	 * <br>pre: nivelActual >= 0</br>
	 * <br>pre: puntajeActual >= 0</br>
	 */
	public void verificarInvariante(){
		assert nombre != null && !nombre.equals("") : "El nombre ingresado es invalido";
		assert nivelActual > 0 : "El nivel ingresado es invalido";
		assert puntajeActual >= 0 : "El puntaje actual es invalido";
	}

	public Jugador getAnterior() {
		return anterior;
	}

	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}

	public Jugador getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean estaConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public double getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(double nivelActual) {
		this.nivelActual = nivelActual;
	}

	public double getPuntajeActual() {
		return puntajeActual;
	}

	public void setPuntajeActual(double puntajeActual) {
		this.puntajeActual = puntajeActual;
	}
}
