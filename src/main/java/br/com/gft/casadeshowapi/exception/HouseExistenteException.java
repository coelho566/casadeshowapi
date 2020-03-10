package br.com.gft.casadeshowapi.exception;

public class HouseExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HouseExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public HouseExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
