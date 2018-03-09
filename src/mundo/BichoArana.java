package mundo;

import java.awt.Color;

public class BichoArana extends Bicho{
	
	//Constantes
	public final static String CALIDAD_DEBIL = "debil";
	public final static String CALIDAD_FUERTE = "fuerte";
	
	//Atributos
	private String calidadTelara�a;
	private boolean venenosa;
	
	/**
	 * Metodo que inicializa los atributos de la clase B>ichoArana y la superclase Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * @param calidadTelara�a - Calidad de la telara�a de la ara�a
	 * @param venenosa - Indica si la ara�a es venenosa
	 */
	public BichoArana(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis,
			String calidadTelara�a, boolean venenosa) {
		super(imagen, colorPredominante, puntaje, velocidadAvance, estado,
				tiempoMetamorfosis);
		this.calidadTelara�a = calidadTelara�a;
		this.venenosa = venenosa;
	}

	/**
	 * Metodo que verifica las invariantes de la clase BichoArana
	 * <br>pre: calidadTelara�a != null && !calidadTelara�a.equals("")
	 */
	public void verificarInvariante(){
		
	}
}
