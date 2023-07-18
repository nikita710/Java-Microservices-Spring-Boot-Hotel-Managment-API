package com.lcwd.user.service.payload;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "builder", builderClassName = "Builder")
@ToString
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
