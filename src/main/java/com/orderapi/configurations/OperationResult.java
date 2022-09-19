package com.orderapi.configurations;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.orderapi.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {
        "timestamp",
        "operation_code",
        "operation_description",
        "message",
        "page_index",
        "records_displayed",
        "total_pages",
        "data"})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationResult {

    private int operationCode;
    private String operationDescription;
    private String message;
    private Object data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.APP_TIME_PATTERN)
    @JsonProperty("timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();

    public OperationResult(int status, String operationDescription, Object data) {
        this.operationCode = status;
        this.operationDescription = operationDescription;
        this.data = data;
    }

}
