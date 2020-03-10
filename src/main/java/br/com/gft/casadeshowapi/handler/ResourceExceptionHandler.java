package br.com.gft.casadeshowapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.gft.casadeshowapi.domain.DetalError;
import br.com.gft.casadeshowapi.exception.EventExisteException;
import br.com.gft.casadeshowapi.exception.EventNaoExisteException;
import br.com.gft.casadeshowapi.exception.HouseExistenteException;
import br.com.gft.casadeshowapi.exception.HouseNaoExisteException;
import br.com.gft.casadeshowapi.exception.UserNaoExisteException;
import br.com.gft.casadeshowapi.exception.VendaNaoExisteException;



@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(HouseExistenteException.class)
	public ResponseEntity<DetalError> handleHouseExistenteException
	(HouseExistenteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(409l);
		erro.setTitulo("Casa de show já existe");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(HouseNaoExisteException.class)
	public ResponseEntity<DetalError> handleHouseNaoExisteException
	(HouseNaoExisteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(404l);
		erro.setTitulo("Casa de show não encontrada");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EventExisteException.class)
	public ResponseEntity<DetalError> handleEventExisteException
	(EventExisteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(409l);
		erro.setTitulo("Evento já existe");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(EventNaoExisteException.class)
	public ResponseEntity<DetalError> handleEventNaoExisteException
	(EventNaoExisteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(404l);
		erro.setTitulo("Evento não encontrada");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalError> handleDataIntegrityViolationException
	(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(UserNaoExisteException.class)
	public ResponseEntity<DetalError> handleUserNaoExisteException
	(UserNaoExisteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(404l);
		erro.setTitulo("Usuário não encontrada");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(VendaNaoExisteException.class)
	public ResponseEntity<DetalError> handleVendaNaoExisteException
	(VendaNaoExisteException e, HttpServletRequest request){
		
		DetalError erro = new DetalError();
		erro.setStatus(404l);
		erro.setTitulo("Venda não encontrada");
		erro.setMensagemDesenvolvedor("http://erros.casadeshow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
