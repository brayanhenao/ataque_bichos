package mundo;

import java.awt.Color;

public class BichoArana extends Bicho{
	
	//Constantes
	public final static String CALIDAD_DEBIL = "debil";
	public final static String CALIDAD_FUERTE = "fuerte";
	
	//Atributos
	private String calidadTelaraña;
	private boolean venenosa;
	
	/**
	 * Metodo que inicializa los atributos de la clase B>ichoArana y la superclase Bicho
	 * <br>@param imagen - Imagen que a va a tener el bicho</br>
	 * <br>@param colorPredominante - Color que va a tener el bicho<br>
	 * <br>@param puntaje - Puntaje que otorga el bicho al ser matado<br>
	 * <br>@param velocidadAvance - Velocidad a la que va a avanzar el bicho en la interfaz<br>
	 * <br>@param estado - Estado del bicho dependiendo del nivel<br>
	 * <br>@param tiempoMetamorfosis - Tiempo en que el bicho cambia de estado
	 * @param calidadTelaraña - Calidad de la telaraña de la araña
	 * @param venenosa - Indica si la araña es venenosa
	 */
	public BichoArana(String imagen, Color colorPredominante, double puntaje,
			double velocidadAvance, String estado, double tiempoMetamorfosis,
			String calidadTelaraña, boolean venenosa) {
		super(imagen, colorPredominante, puntaje, velocidadAvance, estado,
				tiempoMetamorfosis);
		this.calidadTelaraña = calidadTelaraña;
		this.venenosa = venenosa;
	}

	/**
	 * Metodo que verifica las invariantes de la clase BichoArana
	 * <br>pre: calidadTelaraña != null && !calidadTelaraña.equals("")
	 */
	public void verificarInvariante(){
		
	}
}
