package example.adapter.delivery;

import example.core.course.model.Course;
import example.core.course.model.CourseCategoryInput;
import example.core.course.model.CoursePriceInput;
import example.core.course.model.CourseRecordInput;
import example.core.course.service.CourseService;

import java.util.List;

public class CourseEndpoints {

    private final CourseService courseService;

    public CourseEndpoints(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<Course> getAllCourses(){
        return courseService.getAllCoursesFilteredByPriceAscendant();
    };

    public Course getCourseByPrice(CoursePriceInput coursePrice){
        return courseService.getCourseByPrice(coursePrice);
    }

    public Course getCourseByCategory(CourseCategoryInput courseCategoryInput){
        return courseService.getCourseByCategory(courseCategoryInput);
    }

    public Course createCourse(CourseRecordInput courseRecordInput){
        return courseService.createCourse(courseRecordInput);
    }
}
