package negocios.exceptions;

public class PedidoNaoExistenteException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PedidoNaoExistenteException(String msg) {
		super(msg);
	}
}
