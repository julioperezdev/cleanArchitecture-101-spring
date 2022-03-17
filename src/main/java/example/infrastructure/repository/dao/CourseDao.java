package example.infrastructure.repository.dao;

import example.infrastructure.repository.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Long> {

    @Query(value = "SELECT * FROM COURSE WHERE PRICE = :price ", nativeQuery = true)
    CourseEntity getCourseByPrice(@Param("price") Long price);
}
