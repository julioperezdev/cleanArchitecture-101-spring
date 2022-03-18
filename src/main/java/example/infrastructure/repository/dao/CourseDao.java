package example.infrastructure.repository.dao;

import example.infrastructure.repository.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Long> {

    @Query(value = "SELECT * FROM COURSE WHERE PRICE = :price ", nativeQuery = true)
    Optional<CourseEntity> getCourseByPrice(@Param("price") Long price);

    Optional<CourseEntity> getCourseEntityByCategory(String category);
}
