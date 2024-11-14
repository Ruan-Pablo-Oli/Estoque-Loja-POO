package negocios.exceptions;

public class ExistenteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExistenteException(String msg) {
		super(msg);
	}
}
