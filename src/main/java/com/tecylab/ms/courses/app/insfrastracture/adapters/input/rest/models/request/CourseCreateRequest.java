package com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {

  @NotBlank(message = "Field name cannot be null or empty.")
  private String name;

}
