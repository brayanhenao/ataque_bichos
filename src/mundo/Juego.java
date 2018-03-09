package mundo;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Juego {

	// Atributos
	public final static int NIVELES_MÁXIMOS = 5;
	private Nivel[] niveles;
	private Jugador primerJugador;

	private String backupJugadores;
	private File estadoJugadores;

	private String erroresGenerados;
	private File errores;

	/**
	 * <br>
	 * Metodo que inicializa los atributos de la clase Juego</br> <br>
	 * post: Se han inicializado los atributos de la clase Juego</br>
	 */
	public Juego() {
		niveles = new Nivel[NIVELES_MÁXIMOS];
	
		primerJugador = null;
		inicializarNiveles();
		

		backupJugadores = "Backup/estadoJugadores.txt";
		estadoJugadores = new File(backupJugadores);
		erroresGenerados = "Backup/erroresGenerados.txt";
		errores = new File(backupJugadores);

		if (estadoJugadores.exists()) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(estadoJugadores));
				primerJugador=(Jugador)ois.readObject();
				ois.close();
			} catch (Exception e) {
				registrarError(e);
			}
		}
	}
	
	public void iniciarSesion(String nombre){
		buscarJugador(nombre).setConectado(true);
	}

	/**
	 * <br>
	 * Este metodo se encargar de verificar los invariantes de la clase
	 * Juego</br> <br>
	 * pre: niveles != null</br>
	 */
	public void verificarInvariante() {
		assert niveles != null : "No se han inicializado los niveles";

	}

	/**
	 * <br>
	 * Metodo que inicializa los niveles con su respectivo nivel</br> <br>
	 * post: Se han creado todos los niveles</br>
	 */
	public void inicializarNiveles() {
		for (int i = 0; i < 5; i++) {
			niveles[i] = new Nivel(i);
		}
	}

	/**
	 * <br>
	 * Este metodo se encarga de serializar el mundo en un archivo de texto</br> <br>
	 * Pre: niveles != null</br> <br>
	 * Post: Se ha serializado el mundo</br> <br>
	 * @throws Exception: Excepción si no se logra guardar correctamente el
	 * mundo</br>
	 */
	public void guardarInfo() throws Exception {
		try {

			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(estadoJugadores));
			oos.writeObject(primerJugador);
			oos.close();
		} catch (IOException e) {
			registrarError(e);
			throw new PersistenciaException(
					"Error al guardar el estado de los jugadores: "
							+ e.getMessage());
		}
	}

	/**
	 * <br>
	 * El método se encarga de ordenar los niveles de menor a mayor dependiendo
	 * de su puntaje</br> <br>
	 * pre: niveles != null</br> <br>
	 * post: Se han ordenado los niveles por puntaje</br>
	 */
	public void ordenarNivelesPorPuntaje() {
		for (int i = 1; i < niveles.length; i++) {
			Nivel porInsertar = niveles[i];
			boolean termino = false;
			for (int j = i; j > 0 && !termino; j--) {
				Nivel actual = niveles[j - 1];
				if (actual.compararPorPuntajeActual(porInsertar) > 0) {
					niveles[j] = actual;
					niveles[j - 1] = porInsertar;
				}
			}
		}
	}

	/**
	 * <br>
	 * Este metodo se encargar de buscar un nivel en el areglo de niveles</br> <br>
	 * pre: niveles != null</br> <br>
	 * @param nivel - Numero del nivel que se quiere buscar</br> <br>
	 * @return nivel - El nivel buscado</br>
	 */
	public Nivel buscarNivel(int nivel) {
		Nivel buscado = null;
		for (int i = 0; i < niveles.length; i++) {
			Nivel actual = niveles[i];
			if (actual != null && nivel == actual.getNivel()) {
				buscado = actual;
				break;
			}
		}
		return buscado;
	}

	/**
	 * <br>
	 * Este metodo se encarga de buscar un jugador en la lista doblemente
	 * enlazada</br> <br>
	 * pre: primerJugador != null</br> <br>
	 * @param nombre - Nombre del jugador buscado</br> <br>
	 * @return jugador - EL jugador buscado</br>
	 */
	public Jugador buscarJugador(String nombre) {
		Jugador actual = primerJugador;
		while (actual != null && !actual.getNombre().equals(nombre)) {
			actual = actual.getSiguiente();
		}
		return actual;
	}

	/**
	 * <br>
	 * Este metodo se encarga de registrar un jugador en la lista doblemente
	 * enlazada</br> <br>
	 * @param nombre - Nombre del nuevo jugador</br> <br>
	 * @param nivelActual - Nivel actual en que inicia el jugador</br> <br>
	 * @param puntajeActual - Puntaje con el que inicia el jugador</br>
	 */
	public void registrarJugador(String nombre, String password) {
		Jugador jugador = new Jugador(nombre, password);
		insertarJugadorAlFinal(jugador);

	}

	/**
	 * <br>
	 * Este metodo se encarga de registrar los errores generados en el
	 * juego</br>
	 */
	public void registrarError(Exception excepcion) {
		try {
			FileWriter out = new FileWriter(errores, true);
			PrintWriter log = new PrintWriter(out);
			log.println("----------------------------------------------------");
			log.println("Ataque de los Bichos: " + new Date().toString());
			log.println("----------------------------------------------------");
			excepcion.printStackTrace(log);
			log.close();
			out.close();

		} catch (IOException e) {
			excepcion.printStackTrace();
			e.printStackTrace();
		}
	}

	/**
	 * <br>
	 * Este metodo inserta un jugador al final de la lista doblemente
	 * enlazada</br>
	 */
	public void insertarJugadorAlFinal(Jugador jugador) {
		if (primerJugador == null) {
			primerJugador = jugador;
		} else {
			Jugador actual = primerJugador;
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(jugador);
			jugador.setAnterior(actual);
		}
	}

	/**
	 * Este metodo se encarga de cerrar la sesión del jugador actual
	 */
	public void cerrarSesion() {
		Jugador actual = primerJugador;
		while (actual != null) {
			if (actual.estaConectado()) {
				actual.setConectado(false);
				break;
			}
		}
	}

	/**
	 * <br>
	 * Este metodo genera un numero entre un rango asignado</br> <br>
	 * @param numInicial: Mínimo numero que lanzara el metodo</br> <br>
	 * @param numFinal: Máximo numero que lanzara el metodo</br> <br>
	 * @return numero entre el numero inicial y el numero final
	 * incluyendolos</br>
	 */
	public int numeroAleatorio(int x, int y) {
		Random rnd = new Random();
		return rnd.nextInt(y - x + 1) + x;
	}

	/**
	 * <br>
	 * Este metodo se encarga de generar 100 bichos, 20 en cada nivel</br> <br>
	 * pre: Niveles != null && niveles.getBichos() != null</br> <br>
	 * post: Se han generado 100 bichos</br>
	 */
	public void generarBichos() {
		for (int i = 0; i < niveles.length; i++) {
			Nivel actual = niveles[i];
			int uno = numeroAleatorio(1, Nivel.MAXIMO_BICHOS_POR_ESPECIE);
			generarCucaracha(i, uno);
			// --------------------------------------------
			int dos = numeroAleatorio(1, 19 - actual.getBichos().size());
			generarArana(i, dos);
			// --------------------------------------------
			int tres = numeroAleatorio(1, 20 - actual.getBichos().size());
			generarMosca(i, tres);
			// --------------------------------------------
			int cuatro = 20 - actual.getBichos().size();
			generarZancudo(i, cuatro);
			System.out.println(actual.getBichos().size());
		}
	}

	/**
	 * <br>
	 * Este metodo genera una cantidad de cucarachas por un nivel asignado</br> <br>
	 * @param nivel: Nivel al cual se le van a generar las cucarachas</br> <br>
	 * @param cantidad: Cantidad de cucarachas que se necesitan generar</br> <br>
	 * post: Se han generado las cucarachas</br>
	 */
	public void generarCucaracha(int nivel, int cantidad) {
		if (nivel == 0) {
			Nivel actual = niveles[0];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean voladora = generarVoladoraAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoCucaracha cucaracha = new BichoCucaracha(null, color, 10,
						10, estado, 10, voladora, clicksMuerte);
				actual.agregarBicho(cucaracha);
			}
		} else if (nivel == 1) {
			Nivel actual = niveles[1];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean voladora = generarVoladoraAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoCucaracha cucaracha = new BichoCucaracha(null, color, 20,
						20, estado, 8, voladora, clicksMuerte);
				actual.agregarBicho(cucaracha);
			}
		} else if (nivel == 2) {
			Nivel actual = niveles[2];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean voladora = generarVoladoraAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoCucaracha cucaracha = new BichoCucaracha(null, color, 30,
						30, estado, 6, voladora, clicksMuerte);
				actual.agregarBicho(cucaracha);
			}
		} else if (nivel == 3) {
			Nivel actual = niveles[3];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean voladora = generarVoladoraAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoCucaracha cucaracha = new BichoCucaracha(null, color, 40,
						40, estado, 4, voladora, clicksMuerte);
				actual.agregarBicho(cucaracha);
			}
		} else if (nivel == 4) {
			Nivel actual = niveles[4];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean voladora = generarVoladoraAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoCucaracha cucaracha = new BichoCucaracha(null, color, 50,
						50, estado, 2, voladora, clicksMuerte);
				actual.agregarBicho(cucaracha);
			}
		}
	}

	/**
	 * <br>
	 * Este metodo genera una cantidad de arañas por un nivel asignado</br> <br>
	 * @param nivel: Nivel al cual se le van a generar las arañas</br> <br>
	 * @param cantidad: Cantidad de arañas que se necesitan generar</br> <br>
	 * post: Se han generado las arañas</br>
	 */
	public void generarArana(int nivel, int cantidad) {
		if (nivel == 0) {
			Nivel actual = niveles[0];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean venenosa = generarVenenosaAleatoria();
				int clicksMuerte = numeroAleatorio(1, 4);
				BichoArana arana = new BichoArana(null, color, 10, 10, estado,
						10, "Buena", venenosa);
				actual.agregarBicho(arana);
			}
		} else if (nivel == 1) {
			Nivel actual = niveles[1];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean venenosa = generarVenenosaAleatoria();
				String calidad = generarCalidadTelaranaAleatoria();
				BichoArana arana = new BichoArana(null, color, 20, 20, estado,
						8, calidad, venenosa);
				actual.agregarBicho(arana);
			}
		} else if (nivel == 2) {
			Nivel actual = niveles[2];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean venenosa = generarVenenosaAleatoria();
				String calidad = generarCalidadTelaranaAleatoria();
				BichoArana arana = new BichoArana(null, color, 30, 30, estado,
						6, calidad, venenosa);
				actual.agregarBicho(arana);
			}
		} else if (nivel == 3) {
			Nivel actual = niveles[3];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean venenosa = generarVenenosaAleatoria();
				String calidad = generarCalidadTelaranaAleatoria();
				BichoArana arana = new BichoArana(null, color, 40, 40, estado,
						4, calidad, venenosa);
				actual.agregarBicho(arana);
			}
		} else if (nivel == 4) {
			Nivel actual = niveles[4];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				boolean venenosa = generarVenenosaAleatoria();
				String calidad = generarCalidadTelaranaAleatoria();
				BichoArana arana = new BichoArana(null, color, 50, 50, estado,
						2, calidad, venenosa);
				actual.agregarBicho(arana);
			}
		}
	}

	/**
	 * <br>
	 * Este metodo genera una cantidad de moscas por un nivel asignado</br> <br>
	 * @param nivel: Nivel al cual se le van a generar las moscas</br> <br>
	 * @param cantidad: Cantidad de moscas que se necesitan generar</br> <br>
	 * post: Se han generado las moscas</br>
	 */
	public void generarMosca(int nivel, int cantidad) {
		if (nivel == 0) {
			Nivel actual = niveles[0];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				int tamano = numeroAleatorio(1, 10);
				int numeroHuevosPuestos = numeroAleatorio(0, 4);
				BichoMosca mosca = new BichoMosca(null, color, 10, 10, estado,
						10, tamano, numeroHuevosPuestos);
				actual.agregarBicho(mosca);
			}
		} else if (nivel == 1) {
			Nivel actual = niveles[1];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				int tamano = numeroAleatorio(1, 10);
				int numeroHuevosPuestos = numeroAleatorio(0, 4);
				BichoMosca mosca = new BichoMosca(null, color, 20, 20, estado,
						8, tamano, numeroHuevosPuestos);
				actual.agregarBicho(mosca);
			}
		} else if (nivel == 2) {
			Nivel actual = niveles[2];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				int tamano = numeroAleatorio(1, 10);
				int numeroHuevosPuestos = numeroAleatorio(0, 4);
				BichoMosca mosca = new BichoMosca(null, color, 30, 30, estado,
						6, tamano, numeroHuevosPuestos);
				actual.agregarBicho(mosca);
			}
		} else if (nivel == 3) {
			Nivel actual = niveles[3];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				int tamano = numeroAleatorio(1, 10);
				int numeroHuevosPuestos = numeroAleatorio(0, 4);
				BichoMosca mosca = new BichoMosca(null, color, 40, 40, estado,
						4, tamano, numeroHuevosPuestos);
				actual.agregarBicho(mosca);
			}
		} else if (nivel == 4) {
			Nivel actual = niveles[4];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				int tamano = numeroAleatorio(1, 10);
				int numeroHuevosPuestos = numeroAleatorio(0, 4);
				BichoMosca mosca = new BichoMosca(null, color, 50, 50, estado,
						2, tamano, numeroHuevosPuestos);
				actual.agregarBicho(mosca);
			}
		}
	}

	/**
	 * <br>
	 * Este metodo genera una cantidad de zancudos por un nivel asignado</br> <br>
	 * @param nivel: Nivel al cual se le van a generar los zancudos</br> <br>
	 * @param cantidad: Cantidad de zancudos que se necesitan generar</br> <br>
	 * post: Se han generado los zancudos</br>
	 */
	public void generarZancudo(int nivel, int cantidad) {
		if (nivel == 0) {
			Nivel actual = niveles[0];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				char sexo = generarSexoAleatorio();
				boolean transmite = generarTransmiteAleatorio();
				int numeroPicados = numeroAleatorio(0, 4);
				BichoZancudo zancudo = new BichoZancudo(null, color, 10, 10,
						estado, 10, sexo, transmite, numeroPicados);
				actual.agregarBicho(zancudo);
			}
		} else if (nivel == 1) {
			Nivel actual = niveles[1];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				char sexo = generarSexoAleatorio();
				boolean transmite = generarTransmiteAleatorio();
				int numeroPicados = numeroAleatorio(0, 4);
				BichoZancudo zancudo = new BichoZancudo(null, color, 20, 20,
						estado, 8, sexo, transmite, numeroPicados);
				actual.agregarBicho(zancudo);
			}
		} else if (nivel == 2) {
			Nivel actual = niveles[2];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				char sexo = generarSexoAleatorio();
				boolean transmite = generarTransmiteAleatorio();
				int numeroPicados = numeroAleatorio(0, 4);
				BichoZancudo zancudo = new BichoZancudo(null, color, 30, 30,
						estado, 6, sexo, transmite, numeroPicados);
				actual.agregarBicho(zancudo);
			}
		} else if (nivel == 3) {
			Nivel actual = niveles[3];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				char sexo = generarSexoAleatorio();
				boolean transmite = generarTransmiteAleatorio();
				int numeroPicados = numeroAleatorio(0, 4);
				BichoZancudo zancudo = new BichoZancudo(null, color, 40, 40,
						estado, 4, sexo, transmite, numeroPicados);
				actual.agregarBicho(zancudo);
			}
		} else if (nivel == 4) {
			Nivel actual = niveles[4];
			for (int i = 0; i < cantidad; i++) {
				Color color = generarColorAleatorio();
				String estado = generarEstadoAleatorio();
				char sexo = generarSexoAleatorio();
				boolean transmite = generarTransmiteAleatorio();
				int numeroPicados = numeroAleatorio(0, 4);
				BichoZancudo zancudo = new BichoZancudo(null, color, 50, 50,
						estado, 2, sexo, transmite, numeroPicados);
				actual.agregarBicho(zancudo);
			}
		}
	}

	/**
	 * <br>
	 * Este metodo genera uno de los tres estados que puede llegar a tener
	 * cualquier bicho</br> <br>
	 * @return Objeto de tipo String indicando un estado de un Bicho</br>
	 */
	public String generarEstadoAleatorio() {
		int aleatorio = numeroAleatorio(1, 3);
		switch (aleatorio) {
		case 1:
			return Bicho.ESTADO_HUEVO;
		case 2:
			return Bicho.ESTADO_LARVA;
		default:
			return Bicho.ESTADO_FINAL;
		}
	}

	/**
	 * <br>
	 * Este metodo genera una calidad de telaraña de forma aleatoria</br> <br>
	 * @return CALIDAD_DEBIL si aleatorio es igual a 0, CALIDAD_FUERTE en caso
	 * contrario</br>
	 */
	public String generarCalidadTelaranaAleatoria() {
		int aleatorio = numeroAleatorio(0, 1);
		if (aleatorio == 0)
			return BichoArana.CALIDAD_DEBIL;
		else
			return BichoArana.CALIDAD_FUERTE;
	}

	/**
	 * <br>
	 * Este metodo genera un caracter entre 'M' o 'H' de forma aleatoria</br> <br>
	 * @return 'H' si aleatorio es igual a 0, 'M' en caso contrario</br>
	 */
	public char generarSexoAleatorio() {
		int aleatorio = numeroAleatorio(0, 1);
		if (aleatorio == 0)
			return BichoZancudo.SEXO_HEMBRA;
		else
			return BichoZancudo.SEXO_MACHO;
	}

	/**
	 * <br>
	 * Este metodo genera un color aleatorio</br> <br>
	 * @return Objeto de tipo Color</br>
	 */
	public Color generarColorAleatorio() {
		Color[] colores = new Color[5];
		colores[0] = Color.YELLOW;
		colores[1] = Color.BLUE;
		colores[2] = Color.RED;
		colores[3] = Color.CYAN;
		colores[4] = Color.GREEN;
		int aleatorio = numeroAleatorio(0, 4);
		return colores[aleatorio];
	}

	/**
	 * <br>
	 * Este metodo genera un valor booleano aleatorio</br> <br>
	 * @return True si numero es igual a 0, de lo contrario retorna False</br>
	 */
	public boolean generarVoladoraAleatoria() {
		int numero = numeroAleatorio(0, 1);
		if (numero == 0)
			return true;
		else
			return false;
	}

	/**
	 * <br>
	 * Este metodo genera un valor booleano aleatorio</br> <br>
	 * @return True si numero es igual a 0, de lo contrario retorna False</br>
	 */
	public boolean generarTransmiteAleatorio() {
		int numero = numeroAleatorio(0, 1);
		if (numero == 0)
			return true;
		else
			return false;
	}

	/**
	 * <br>
	 * Este metodo genera un valor booleano aleatorio</br> <br>
	 * @return True si numero es igual a 0, de lo contrario retorna False</br>
	 */
	public boolean generarVenenosaAleatoria() {
		int numero = numeroAleatorio(0, 1);
		if (numero == 0)
			return true;
		else
			return false;
	}

	public int darCantidadBichos() {
		int c = 0;
		for (int i = 0; i < niveles.length; i++) {
			Nivel nivel = niveles[i];
			for (int j = 0; j < nivel.getBichos().size(); j++) {
				c++;
			}
		}
		return c;
	}

	public Nivel[] darNivel() {
		return niveles;
	}
}
