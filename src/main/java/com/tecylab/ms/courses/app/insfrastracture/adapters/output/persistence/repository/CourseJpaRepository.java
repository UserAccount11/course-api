package com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.repository;

import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseJpaRepository extends CrudRepository<CourseEntity, Long> {

  @Query("DELETE FROM CourseStudent cs WHERE cs.studentId = ?1")
  void deleteCourseStudentByStudentId(Long studentId);

}
