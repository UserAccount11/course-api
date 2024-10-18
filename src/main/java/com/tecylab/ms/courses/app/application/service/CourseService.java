package com.tecylab.ms.courses.app.application.service;

import com.tecylab.ms.courses.app.application.ports.input.CourseInputPort;
import com.tecylab.ms.courses.app.application.ports.input.ExternalStudentsInputPort;
import com.tecylab.ms.courses.app.application.ports.output.CoursePersistencePort;
import com.tecylab.ms.courses.app.application.ports.output.ExternalStudentsOutputPort;
import com.tecylab.ms.courses.app.domain.exceptions.CourseNotFoundException;
import com.tecylab.ms.courses.app.domain.models.Course;
import com.tecylab.ms.courses.app.domain.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseInputPort, ExternalStudentsInputPort {

  private final CoursePersistencePort coursePersistencePort;
  private final ExternalStudentsOutputPort externalStudentsOutputPort;

  @Override
  public Course findById(Long id) {
    return coursePersistencePort.findById(id)
        .orElseThrow(CourseNotFoundException::new);
  }

  @Override
  public List<Course> findAll() {
    return coursePersistencePort.findAll();
  }

  @Override
  public Course save(Course course) {
    return coursePersistencePort.save(course);
  }

  @Override
  public Course update(Long id, Course course) {
    return coursePersistencePort.findById(id)
        .map(savedCourse -> {
          savedCourse.setName(course.getName());
          return coursePersistencePort.save(savedCourse);
        }).orElseThrow(CourseNotFoundException::new);
  }

  @Override
  public void deleteById(Long id) {
    if (coursePersistencePort.findById(id).isEmpty()) {
      throw new CourseNotFoundException();
    }
    coursePersistencePort.deleteById(id);
  }

  @Override
  public Student addStudentToCourse(Long courseId, Long studentId) {
    return externalStudentsOutputPort.addStudentToCourse(courseId, studentId);
  }

  @Override
  public Student removeStudentFromCourse(Long courseId, Long studentId) {
    return externalStudentsOutputPort.removeStudentFromCourse(courseId, studentId);
  }

  @Override
  public void removeStudentFromCollection(Long studentId) {
    externalStudentsOutputPort.removeStudentFromCollection(studentId);
  }

}
