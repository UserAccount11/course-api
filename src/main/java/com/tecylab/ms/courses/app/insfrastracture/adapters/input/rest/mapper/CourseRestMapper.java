package com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.mapper;

import com.tecylab.ms.courses.app.domain.models.Course;
import com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.request.CourseCreateRequest;
import com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseRestMapper {

  Course toCourse(CourseCreateRequest request);

  CourseResponse toCourseResponse(Course course);

  List<CourseResponse> toCourseResponses(List<Course> courses);

}
