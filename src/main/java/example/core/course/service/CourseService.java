package example.core.course.service;

import example.core.course.model.Course;
import example.core.course.model.CourseCategoryInput;
import example.core.course.model.CoursePriceInput;
import example.core.course.model.CourseRecordInput;
import example.core.course.port.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCoursesFilteredByPriceAscendant(){
        return courseRepository.getAllCourses();
    }

    public Course getCourseByPrice(CoursePriceInput coursePrice){
        return courseRepository.getCourseByPrice(coursePrice.getPrice());
    }

    public Course getCourseByCategory(CourseCategoryInput courseCategoryInput){
        return courseRepository.getCourseByCategory(courseCategoryInput.getCategory());
    }

    public Course createCourse(CourseRecordInput courseRecordInput){
        CourseRecordInput courseRecord = Optional.of(courseRecordInput).orElseThrow(IllegalArgumentException::new);
        if(courseRecord.validateFields()){
            throw new RuntimeException("Bad request information to record Course");
        }
        return courseRepository.createCourse(
                courseRecordInput.getName(),
                courseRecordInput.getPrice(),
                courseRecordInput.getCategory());
    }
}


