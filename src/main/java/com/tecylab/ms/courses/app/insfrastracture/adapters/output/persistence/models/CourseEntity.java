package com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "courses")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @JoinColumn(name = "course_id")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CourseStudent> courseStudentList;

  public CourseEntity() {
    this.courseStudentList = new ArrayList<>();
  }

  public void addCourseStudent(CourseStudent courseStudent) {
    this.courseStudentList.add(courseStudent);
  }

  public void removeCourseStudent(CourseStudent courseStudent) {
    this.courseStudentList.remove(courseStudent);
  }

}
