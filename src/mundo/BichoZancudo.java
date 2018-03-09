package mundo;

import java.awt.Color;

public class BichoZancudo extends Bicho{

	//Constante
	public final static char SEXO_MACHO = 'M';
	public final static char SEXO_HEMBRA = 'H';
	
	//Atributos
	private char sexo;
	private boolean transmite;
	private int numeroPicados;
	
	/**
	  * Metodo que inicializa los atributos de la clase BichoMosca y la superclase Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * <br>@param sexo - Sexo del zancudo</br>
	 * <br>@param transmite - Indica si el zancudo es transmisor  de virus</br>
	 * <br>@param numeroPicados - Cantidad de personas picadas por el zancudo</br>
	 */
	public BichoZancudo(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis,
			char sexo, boolean transmite, int numeroPicados) {
		super(imagen, colorPredominante, puntaje, velocidadAvance, estado,
				tiempoMetamorfosis);
		this.sexo = sexo;
		this.transmite = transmite;
		this.numeroPicados = numeroPicados;
	}
	
	/**
	 * Metodo que verifica las invariantes de la clase BichoZancudo
	 * <br>pre: numeroPicados >= 0</br>
	 */
	public void verificarInvariante(){
		
	}
}
