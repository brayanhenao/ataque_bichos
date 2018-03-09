package mundo;

import java.io.Serializable;
import java.util.ArrayList;

public class Nivel implements Serializable{

	//Atributos
	public final static int NIVEL_UNO= 1;
	public final static int NIVEL_DOS= 2;
	public final static int NIVEL_TRES= 3;
	public final static int NIVEL_CUATRO= 4;
	public final static int NIVEL_CINCO= 5;
	public final static int MAXIMO_BICHOS_POR_ESPECIE = 18;
	public final static int NUMERO_INSECTOS_POR_NIVEL= 20;
	
	private int nivel;
	private double insectosEliminados;
	private	double puntajeActual;
	private ArrayList<Bicho> bichos;
	
	/**
	 * Metodo que inicializa todos los atributos de la clase nivel
	 * <br>post: Se han inicializado todos los atributos de la clase Nivel</br>
	 */
	public Nivel(int nivel) {
		this.nivel = nivel;
		this.insectosEliminados = 0;
		this.puntajeActual = 0;
		bichos = new ArrayList<Bicho>();
	}
	
	/**
	 * Este metodo se encargar de verificar los invariantes de la clase Nivel
	 * <br>pre: nivel >= 0</br>
	 * <br>pre: insectosEliminados >= 0</br>
	 * <br>pre: puntajeActual >= 0</br>
	 * <br>pre: bichos != null</br>
	 */
	public void verificarInvariante(){
		
	}

	/**
	 * Este metodo compara el puntaje del nivel actual con el del pasado por parametro
	 * <br>@param nivel - Nivel con el que se va a comparar</br>
	 * @return -1 || 0 || 1 - Depende si el puntaje actual es menor, igual o mayor al nivel pasado por parametro
	 */
	public int compararPorPuntajeActual(Nivel nivel){
		if(puntajeActual == nivel.getPuntajeActual())
			return 0;
		else if(puntajeActual > nivel.getPuntajeActual())
			return 1;
		else
			return -1;
	}
	
	/**
	 * <br>Este metodo se agregar un bicho al arrayList de bichos</br>
	 * <br>pre: bichos != null</br>
	 * <br>post: Se ha agregado un bicho</br>
	 */
	public void agregarBicho(Bicho bicho){
		bichos.add(bicho);
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getInsectosEliminados() {
		return insectosEliminados;
	}

	public void setInsectosEliminados(double insectosEliminados) {
		this.insectosEliminados = insectosEliminados;
	}

	public double getPuntajeActual() {
		return puntajeActual;
	}

	public void setPuntajeActual(double puntajeActual) {
		this.puntajeActual = puntajeActual;
	}

	public ArrayList<Bicho> getBichos() {
		return bichos;
	}

	public void setBichos(ArrayList<Bicho> bichos) {
		this.bichos = bichos;
	}
	
	
}
