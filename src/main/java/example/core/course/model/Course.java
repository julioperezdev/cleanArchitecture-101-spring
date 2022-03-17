package example.core.course.model;

public class Course {
    Long id;
    String name;
    Long price;
    String category;

    public Course(Long id, String name, Long price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
