package example.infrastructure.delivery;

import example.adapter.delivery.CourseEndpoints;
import example.core.course.model.Course;
import example.core.course.model.CourseCategoryInput;
import example.core.course.model.CoursePriceInput;
import example.core.course.model.CourseRecordInput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@AllArgsConstructor
@Slf4j
public class SpringCourseController {

    private final CourseEndpoints courseEndpoints;

    @GetMapping
    public List<Course> getAllCourses(){
        log.info("Executing get all courses");
        return courseEndpoints.getAllCourses();
    }

    @GetMapping("/get/by/price")
    public Course getCourseByPrice(@RequestBody CoursePriceInput coursePrice){
        return courseEndpoints.getCourseByPrice(coursePrice);
    }

    @GetMapping("/get/by/category")
    public Course getCourseByCategory(@RequestBody CourseCategoryInput courseCategoryInput){
        return courseEndpoints.getCourseByCategory(courseCategoryInput);
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody CourseRecordInput courseRecordInput){
        return courseEndpoints.createCourse(courseRecordInput);
    }
}
