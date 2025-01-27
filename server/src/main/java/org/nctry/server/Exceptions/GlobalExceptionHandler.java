package org.nctry.server.Exceptions;


import org.nctry.server.Exceptions.DTO.ErrorDetails;
import org.nctry.server.Exceptions.user.IncorrectPasswordException;
import org.nctry.server.Exceptions.user.UserAlreadyExistsException;
import org.nctry.server.Exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Unauthorized");
        response.put("message", ex.getMessage());
        response.put("path", request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    //en caso de que el usuario no exista
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), "El usuario no existe");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //en caso de que se quiera registrar un usuario con un nombre de usuario o email ya existentes
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), "El nombre de usuario o correo ya fueron registrados");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT); //error 409
    }

    //en caso de que la contraseña no sea la correcta
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorDetails> handleIncorrectPasswordException(IncorrectPasswordException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //en caso de que el json este mal formado como falta de llaves, sucede en el nivel de controllers
    @ExceptionHandler(HttpMessageNotReadableException.class) //clase por default de spring boot
    public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), "El cuerpo de la solicitud no es válido o está mal formado.", null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); //error 400
    }

    //en caso de que se incumplan las anotaciones definidas en los dto, sucede en el nivel de controllers
    @ExceptionHandler(MethodArgumentNotValidException.class) //clase por default de spring boot
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            response.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); //error 400
    }

}
