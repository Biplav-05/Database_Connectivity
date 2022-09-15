package com.example.database_connectivity.advice;

import com.example.database_connectivity.exception.UpdateFaliureException;
import com.example.database_connectivity.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ApiResponse {

    @ExceptionHandler(UpdateFaliureException.class)
    public ApiResponse handleUpdateException(UpdateFaliureException updateFaliureException)
    {
            return error(updateFaliureException.getMessage(),null);
    }
}
