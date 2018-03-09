package mundo;

public class PersistenciaException extends Exception{

	private String mensaje;
	public PersistenciaException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return mensaje;
	}

}
