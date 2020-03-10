package br.com.gft.casadeshowapi.exception;

public class EventNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EventNaoExisteException(String menssagem) {
		super(menssagem);
	}

	public EventNaoExisteException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}

}
