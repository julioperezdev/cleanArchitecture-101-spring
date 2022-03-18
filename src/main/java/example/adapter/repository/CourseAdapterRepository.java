package example.adapter.repository;

import example.adapter.shared.ModelMapper;
import example.core.course.model.Course;
import example.core.course.port.CourseRepository;
import example.infrastructure.repository.dao.CourseDao;
import example.infrastructure.repository.model.CourseEntity;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CourseAdapterRepository implements CourseRepository {

    private final CourseDao courseDao;
    private final ModelMapper modelMapper;

    @Override
    public List<Course> getAllCourses() {
        List<CourseEntity> courseEntities = Optional
                .of(courseDao.findAll())
                .orElseThrow(IllegalArgumentException::new);
        if(courseEntities.isEmpty()){
            throw new IllegalArgumentException("dont has record it the courses");
        }
        return courseEntities.stream()
                .map(modelMapper::toDomainModel)
                .toList();
    }

    @Override
    public Course getCourseByPrice(Long coursePrice) {
        CourseEntity courseEntity = courseDao.getCourseByPrice(coursePrice)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.toDomainModel(courseEntity);
    }

    @Override
    public Course getCourseByCategory(String category) {
        CourseEntity courseEntityByCategory = courseDao
                .getCourseEntityByCategory(category)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.toDomainModel(courseEntityByCategory);
    }

    @Override
    public Course createCourse(String name, Long price, String category) {
        Course courseToRecord = new Course(name, price, category);
        CourseEntity courseEntityRecorded = Optional
                .of(courseDao.save(modelMapper.toEntity(courseToRecord)))
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.toDomainModel(courseEntityRecorded);
    }
}
