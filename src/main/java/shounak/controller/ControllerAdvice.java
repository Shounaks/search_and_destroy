package shounak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shounak.exception.SNDException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralError(Exception ex){
        return new ResponseEntity<>("Something Went Wrong...", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SNDException.class)
    public ResponseEntity<String> handleGeneralError(SNDException sndException){
        return new ResponseEntity<>("Something Went Wrong 2 : Electric Boogaloo", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
