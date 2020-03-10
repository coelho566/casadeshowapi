package br.com.gft.casadeshowapi.exception;

public class VendaNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public VendaNaoExisteException(String menssagem) {
		super(menssagem);
	}
	
	public VendaNaoExisteException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}
	
}
