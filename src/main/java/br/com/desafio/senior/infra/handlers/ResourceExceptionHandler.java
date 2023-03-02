package br.com.desafio.senior.infra.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.desafio.senior.resources.exceptions.OrderNotOpenException;
import br.com.desafio.senior.resources.exceptions.ResourceNotFoundedException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(value = { OrderNotOpenException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage resourceNotFoundException(OrderNotOpenException ex, WebRequest request) {
		return buildErrorMessage(HttpStatus.BAD_REQUEST.value(), "Orderm já fechada",
				"Escolha outra order para aplicar o desconto");
	}
	
	@ExceptionHandler(value = { ResourceNotFoundedException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundedException ex, WebRequest request) {
		return buildErrorMessage(HttpStatus.NOT_FOUND.value(), "Recurso não encontrado",
				"O recurso solicitado não foi encontrado. Por favor, escolha outro");
	}

	private ErrorMessage buildErrorMessage(int code, String message, String description) {
		return ErrorMessage.builder().statusCode(code).timestamp(LocalDateTime.now()).message(message)
				.description(description).build();
	}

}
