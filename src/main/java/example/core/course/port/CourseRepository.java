package example.core.course.port;

import example.core.course.model.Course;


import java.util.List;

public interface CourseRepository {
    List<Course> getAllCourses();
    Course getCourseByPrice(Long coursePrice);
    Course getCourseByCategory(String category);
    Course createCourse(String name, Long price, String category);
}
