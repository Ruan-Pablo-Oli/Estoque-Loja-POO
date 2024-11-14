package negocios;

import negocios.interfaces.ServicoPagamento;

public class PagamentoPix implements ServicoPagamento {

		@Override
	public String realizarPagamento() {
		// TODO Auto-generated method stub
		return "Pagamento Realizado!";
	}

}
