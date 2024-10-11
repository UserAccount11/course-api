package com.tecylab.ms.courses.app.application.ports.output;

import com.tecylab.ms.courses.app.domain.models.Student;

import java.util.Optional;

public interface StudentsOutputPort {

  Student addStudentToCourse(Long courseId, Long studentId);
  Student removeStudentFromCourse(Long courseId, Long studentId);
  void removeStudentFromCollection(Long studentId);

}
