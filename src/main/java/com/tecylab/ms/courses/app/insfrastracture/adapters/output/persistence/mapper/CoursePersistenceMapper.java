package com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.mapper;

import com.tecylab.ms.courses.app.domain.models.Course;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoursePersistenceMapper {

  Course toCourse(CourseEntity entity);

  CourseEntity toCourseEntity(Course course);

  List<Course> toCourses(List<CourseEntity> entities);

}
