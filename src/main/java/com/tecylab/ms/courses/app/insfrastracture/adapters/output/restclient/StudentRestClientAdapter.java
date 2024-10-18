package com.tecylab.ms.courses.app.insfrastracture.adapters.output.restclient;

import com.tecylab.ms.courses.app.application.ports.output.ExternalStudentsOutputPort;
import com.tecylab.ms.courses.app.domain.exceptions.CourseNotFoundException;
import com.tecylab.ms.courses.app.domain.exceptions.NonEnrolledStudentException;
import com.tecylab.ms.courses.app.domain.models.Student;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseStudent;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.repository.CourseJpaRepository;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.restclient.client.StudentFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentRestClientAdapter implements ExternalStudentsOutputPort {

  private final StudentFeignClient client;
  private final CourseJpaRepository repository;

  @Override
  public Student addStudentToCourse(Long courseId, Long studentId) {
    return repository.findById(courseId)
        .map(courseEntity -> {
          Student student = client.findById(studentId); // FeignException -> 404, 400, 500
          CourseStudent courseStudent = new CourseStudent();
          courseStudent.setStudentId(student.getId());
          courseEntity.addCourseStudent(courseStudent);
          repository.save(courseEntity);
          return student;
        }).orElseThrow(CourseNotFoundException::new);
  }

  @Override
  public Student removeStudentFromCourse(Long courseId, Long studentId) {
    return repository.findById(courseId)
        .map(courseEntity -> {
          Student student = client.findById(studentId);
          boolean isEnrolled = courseEntity.getCourseStudentList()
              .stream()
              .anyMatch(cs -> cs.getStudentId().equals(studentId));
          if (isEnrolled) {
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setStudentId(student.getId());
            courseEntity.removeCourseStudent(courseStudent);
            repository.save(courseEntity);
            return student;
          }
          throw new NonEnrolledStudentException(studentId);
        }).orElseThrow(CourseNotFoundException::new);
  }

  @Override
  public void removeStudentFromCollection(Long studentId) {
    repository.deleteCourseStudentByStudentId(studentId);
  }

}
