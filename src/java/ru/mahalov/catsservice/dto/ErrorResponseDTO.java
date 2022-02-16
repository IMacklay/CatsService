package ru.mahalov.catsservice.dto;

import lombok.Value;

@Value
public class ErrorResponseDTO {
    String timestamp;
    String path;
    String message;
    int status;
}