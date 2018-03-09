package mundo;

import java.awt.Color;

public abstract class Bicho {

	//Constantes
	public final static String ESTADO_HUEVO = "huevo";
	public final static String ESTADO_LARVA = "larva";
	public final static String ESTADO_FINAL = "final";
	
	//Atributos
	private String imagen;
	private Color colorPredominante;
	private double puntaje;
	private double velocidadAvance;
	private String estado;
	private double tiempoMetamorfosis;
	
	/**
	 * Metodo que inicializa los atributos de la clase abstracta Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * <br>post: Se han inicializado los atributos de la clase bicho
	 */
	public Bicho(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis) {
		this.imagen = imagen;
		this.colorPredominante = colorPredominante;
		this.puntaje = puntaje;
		this.velocidadAvance = velocidadAvance;
		this.estado = estado;
		this.tiempoMetamorfosis = tiempoMetamorfosis;
	}
	
	/**
	 * Metodo que compara el tiempo de metamorfosis del bicho actual con el del pasado por parametro
	 * <br>@param bicho - Bicho comparador con el bicho actual</br>
	 * <br>@return -1 || 0 || 1 - Depende de si el bicho actual tiene tiempo menor, igual o mayor al bicho del parametro</br>
	 */
	public int compararPorMetamorfosis(Bicho bicho){
		return -1;
	}
	
	/**
	 * Este metodo se encargar de verificar los invariantes de la clase Bicho
	 * <br>imagen != null && !imagen.equals("")</br>
	 * <br>colorPredominante >= 0</br>
	 * <br>puntaje >= 0</br>
	 * <br>velocidadAvance >= 0</br>
	 * <br>estado != null && !estado.equals("")</br>
	 * <br>tiempoMetamorfosis >= 0</br>
	 */
	public void verificarInvariante(){
		
	}
}
