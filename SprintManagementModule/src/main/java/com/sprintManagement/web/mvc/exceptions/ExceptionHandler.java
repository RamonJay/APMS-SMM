package com.sprintManagement.web.mvc.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(MeetingStatusUpdateFailedException.class)
	public ResponseEntity<String> handleMeetingStatusUpdateFailedExceptionHandler(
			MeetingStatusUpdateFailedException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
