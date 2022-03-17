package example.adapter.repository;

import example.adapter.shared.ModelMapper;
import example.core.course.model.Course;
import example.core.course.port.CourseRepository;
import example.infrastructure.repository.dao.CourseDao;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CourseAdapterRepository implements CourseRepository {

    private final CourseDao courseDao;
    private final ModelMapper modelMapper;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll().stream().map(modelMapper::toDto).toList();
    }

    @Override
    public Course getCourseByPrice(Long coursePrice) {
        return Optional.of(modelMapper.toDto(courseDao.getCourseByPrice(coursePrice))).orElse(null);
    }
}
