package br.com.gft.casadeshowapi.exception;

public class EventExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EventExisteException(String menssagem) {
		super(menssagem);
	}
	
	public EventExisteException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}
	
}
