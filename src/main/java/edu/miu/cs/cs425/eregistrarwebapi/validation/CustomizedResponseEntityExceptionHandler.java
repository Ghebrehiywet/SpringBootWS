package edu.miu.cs.cs425.eregistrarwebapi.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatus status,
//                                                                  WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
//                ex.getBindingResult().toString());
//        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(StudentValidationException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(StudentValidationException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//        List<ErrorDetails> errorDetailsList = new ArrayList<>();
//        for (ObjectError error : ex.allErrors) {
//            errorDetailsList.add(new ErrorDetails(new Date(), error.getDefaultMessage(), error.getDefaultMessage()));
////            private Date timestamp;
////            private String message;
////            private String details;
//        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
//        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.allErrors
                //.getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

//    @Override
//    @ExceptionHandler(StudentValidationException.class)
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(StudentValidationException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        //Get all errors
//        List<String> errors = ex.allErrors
//                //.getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, headers, status);
//
//    }
}