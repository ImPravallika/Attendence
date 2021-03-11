package org.oar.app.handler;

import org.oar.app.handler1.NoAttendenceFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=NoAttendenceFound.class)
	public ResponseEntity handleNoProductFoundException()
	{
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	

}
