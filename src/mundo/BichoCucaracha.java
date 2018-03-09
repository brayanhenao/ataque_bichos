package mundo;

import java.awt.Color;

public class BichoCucaracha extends Bicho{

	//Atributos
	private boolean voladora;
	private int clicksMuerte;
	
	/**
	 * Metodo que inicializa los atributos de la clase BichoCucaracha y la superclase Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * @param voladora - Inidica si la cucaracha es voladora
	 * @param clicksMuerte - Clicks necesarios para que la cucaracha muera
	 */
	public BichoCucaracha(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis,
			boolean voladora, int clicksMuerte) {
		super(imagen, colorPredominante, puntaje, velocidadAvance, estado,
				tiempoMetamorfosis);
		this.voladora = voladora;
		this.clicksMuerte = clicksMuerte;
	}
	
	/**
	 * Metodo que verifica las invariantes de la clase BichoCucaracha
	 * <br>pre: clicksMuerte >= 0
	 */
	public void verificarInvariante(){
		
	}
}
