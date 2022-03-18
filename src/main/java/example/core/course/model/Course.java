package example.core.course.model;

public class Course {
    String name;
    Long price;
    String category;

    public Course(String name, Long price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
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
