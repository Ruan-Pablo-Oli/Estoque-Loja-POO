package negocios.exceptions;

public class NaoExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NaoExistenteException(String msg) {
		super(msg);
	}
}
