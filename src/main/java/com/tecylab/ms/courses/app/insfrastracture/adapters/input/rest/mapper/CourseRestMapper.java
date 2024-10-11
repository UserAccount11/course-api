package com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.mapper;

import com.tecylab.ms.courses.app.domain.models.Course;
import com.tecylab.ms.courses.app.insfrastracture.adapters.input.rest.models.request.CourseCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseRestMapper {

  Course toCourse(CourseCreateRequest request);

}
