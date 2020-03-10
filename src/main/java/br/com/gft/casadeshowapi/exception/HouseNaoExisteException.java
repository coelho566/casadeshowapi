package br.com.gft.casadeshowapi.exception;

public class HouseNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HouseNaoExisteException(String menssagem) {
		super(menssagem);
	}
	
	public HouseNaoExisteException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}
	
}
