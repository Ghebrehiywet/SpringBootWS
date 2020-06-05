package edu.miu.cs.cs425.eregistrarwebapi.validation;

import org.springframework.validation.ObjectError;

import java.util.List;

public class StudentValidationException extends Exception {
    List<ObjectError> allErrors;

    public StudentValidationException(List<ObjectError> allErrors) {
        this.allErrors = allErrors;
    }
}
