package negocios.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException(String msg){
		super(msg);
	}

}
