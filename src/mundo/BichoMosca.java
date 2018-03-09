package mundo;

import java.awt.Color;

public class BichoMosca extends Bicho{

	//Atributos
	private int tamano;
	private int numeroHuevosPuestos;
	
	/**
	 * Metodo que inicializa los atributos de la clase BichoMosca y la superclase Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * <br>@param tamano - Tamaño de la mosca</br>
	 * <br>@param numeroHuevosPuestos - Numero de huevos que puede poner la mosca</br>
	 */
	public BichoMosca(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis,
			int tamano, int numeroHuevosPuestos) {
		super(imagen, colorPredominante, puntaje, velocidadAvance, estado,
				tiempoMetamorfosis);
		this.tamano = tamano;
		this.numeroHuevosPuestos = numeroHuevosPuestos;
	}

	/**
	 * Metodo que verifica las invariantes de la clase BichoCucaracha
	 * <br>pre: tamano > 0</br>
	 * <br>pre: numeroHuevosPuestos >= 0</br>
	 */
	public void verificarInvariante(){
		
	}
}
