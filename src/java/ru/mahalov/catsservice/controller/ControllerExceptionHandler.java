package ru.mahalov.catsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.mahalov.catsservice.dto.ErrorResponseDTO;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        return getErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    private ResponseEntity<ErrorResponseDTO> getErrorResponse(
            HttpServletRequest request,
            HttpStatus status,
            Exception exception
    ) {
        if (status.is5xxServerError()) {
            logger.error("unhandled exception caught", exception);
        } else {
            logger.warn(exception.getClass().getName() + ": " + exception.getMessage());
        }
        return ResponseEntity.status(status)
                .body(new ErrorResponseDTO(
                        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                        request.getRequestURL().toString(),
                        exception.getLocalizedMessage(),
                        status.value())
                );
    }
}
