package example.core.course.service;

import example.core.course.model.Course;
import example.core.course.model.CoursePriceInput;
import example.core.course.port.CourseRepository;

import java.util.List;

public class CourseService {

    private CourseRepository courseRepository;

    public List<Course> getAllCoursesFilteredByPriceAscendant(){
        return courseRepository.getAllCourses();
    }

    public Course getCourseByPrice(Long coursePrice){
        return courseRepository.getCourseByPrice(coursePrice);
    }
}


