package com.tecylab.ms.courses.app.domain.exceptions;

public class NonEnrolledStudentException extends RuntimeException {

  public NonEnrolledStudentException(Long id) {
    super("The student with the id: " + id + ", is not enrolled in the course.");
  }
}
