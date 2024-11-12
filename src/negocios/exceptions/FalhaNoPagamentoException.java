package negocios.exceptions;

public class FalhaNoPagamentoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FalhaNoPagamentoException(String msg) {
		super(msg);
	}
}
