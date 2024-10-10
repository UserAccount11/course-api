package com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.response;

import com.tecylab.ms.courses.app.domain.models.Student;
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
public class CourseResponse {

  private Long id;
  private String name;
  private List<Student> students;
  private String timestamp;

}
