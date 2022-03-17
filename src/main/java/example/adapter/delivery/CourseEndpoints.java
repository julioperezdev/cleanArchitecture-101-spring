package example.adapter.delivery;

import example.core.course.model.Course;
import example.core.course.model.CoursePriceInput;
import example.core.course.service.CourseService;

import java.util.List;

public class CourseEndpoints {

    private CourseService courseService;

    public List<Course> getAllCourses(){
        return courseService.getAllCoursesFilteredByPriceAscendant();
    };

    public Course getCourseByPrice(Long coursePrice){
        return courseService.getCourseByPrice(coursePrice);
    }
}
