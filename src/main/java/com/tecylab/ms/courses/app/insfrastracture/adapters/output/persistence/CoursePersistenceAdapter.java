package com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence;

import com.tecylab.ms.courses.app.application.ports.output.CoursePersistencePort;
import com.tecylab.ms.courses.app.domain.models.Course;
import com.tecylab.ms.courses.app.domain.models.Student;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.mapper.CoursePersistenceMapper;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseEntity;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseStudent;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.repository.CourseJpaRepository;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.restclient.client.StudentFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistencePort {

  private final CourseJpaRepository repository;
  private final CoursePersistenceMapper persistenceMapper;
  private final StudentFeignClient client;

  @Override
  public Optional<Course> findById(Long id) {
    return repository.findById(id)
        .map(courseEntity -> {
          List<Long> studentIds = courseEntity.getCourseStudentList()
              .stream()
              .map(CourseStudent::getStudentId)
              .toList();
          List<Student> students = client.findByIds(studentIds);
          Course course = persistenceMapper.toCourse(courseEntity);
          course.setStudents(students);
          return course;
        });
  }

  @Override
  public List<Course> findAll() {
    return persistenceMapper.toCourses(
        (List<CourseEntity>) repository.findAll());
  }

  @Override
  public Course save(Course course) {
    return persistenceMapper.toCourse(
        repository.save(persistenceMapper.toCourseEntity(course)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}
