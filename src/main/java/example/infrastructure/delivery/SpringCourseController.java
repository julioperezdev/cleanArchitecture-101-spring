package example.infrastructure.delivery;

import example.adapter.delivery.CourseEndpoints;
import example.core.course.model.Course;
import example.core.course.model.CoursePriceInput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class SpringCourseController {

    private final CourseEndpoints courseEndpoints;

    @GetMapping("/getall")
    public List<Course> getAllCourses(){
        return null;
    }

    @GetMapping("/get/by/price")
    public Course getCourseByPrice(CoursePriceInput coursePrice){
        return null;
    }
}
