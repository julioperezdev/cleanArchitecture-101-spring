package example.infrastructure.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEntity {
    
    @Id
    private Long id;
    private String name;
    private Long price;
    private String category;
    
}
