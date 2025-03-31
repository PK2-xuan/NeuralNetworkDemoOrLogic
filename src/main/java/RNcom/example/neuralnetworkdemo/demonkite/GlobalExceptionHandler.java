package RNcom.example.neuralnetworkdemo.demonkite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Manejo de excepciones genéricas (errores 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Puedes agregar más detalles sobre el error
        String errorMessage = "Ocurrió un error inesperado en el servidor. Por favor, intente más tarde.";
        
        // Puedes hacer logging del error aquí si lo deseas, por ejemplo con loggers.
        // logger.error("Error: ", ex);
        
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Puedes agregar más controladores de excepciones si es necesario
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        String errorMessage = "Los datos proporcionados están incompletos o son nulos.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = "Los parámetros proporcionados son inválidos.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
