package br.com.gft.casadeshowapi.exception;

public class UserNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserNaoExisteException(String menssagem) {
		super(menssagem);
	}
	
	public UserNaoExisteException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}
	
}
