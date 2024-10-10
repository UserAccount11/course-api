package com.tecylab.ms.courses.app.application.ports.input;

import com.tecylab.ms.courses.app.domain.models.Student;

import java.util.Optional;

public interface StudentsInputPort {

  Optional<Student> addStudentToCourse(Long courseId, Long studentId);
  Optional<Student> removeStudentFromCourse(Long courseId, Long studentId);
  void removeStudentFromCollection(Long studentId);

}
