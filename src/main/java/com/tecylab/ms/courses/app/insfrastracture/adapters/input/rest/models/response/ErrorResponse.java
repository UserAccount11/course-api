package com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.response;

import com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

  private String code;
  private ErrorType errorType; // FUNCTIONAL, SYSTEM
  private String genericMessage;
  private List<String> details;
  private String timestamp;

}
