package br.com.desafio.senior.infra.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.desafio.senior.resources.exceptions.OrderNotOpenException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(value = { OrderNotOpenException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage resourceNotFoundException(OrderNotOpenException ex, WebRequest request) {
		return buildErrorMessage(HttpStatus.BAD_REQUEST.value(), "Orderm já fechada",
				"Escolha outra orderm para aplicar o desconto");
	}

	private ErrorMessage buildErrorMessage(int code, String message, String description) {
		return ErrorMessage.builder().statusCode(code).timestamp(LocalDateTime.now()).message(message)
				.description(description).build();
	}

}
