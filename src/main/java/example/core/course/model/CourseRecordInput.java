package example.core.course.model;

import java.util.Objects;

public class CourseRecordInput {
    private final String name;
    private final String category;
    private final Long price;

    public CourseRecordInput(String name, String category, Long price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getPrice() {
        return price;
    }

    public Boolean validateFields(){
        return validateName() || validatePrice()  || validateCategory();
    }

    private Boolean validateName(){
        return !Objects.equals(name, null) && !Objects.equals(name, "");
    }

    private Boolean validateCategory(){
        return !Objects.equals(category, null) && !Objects.equals(category, "");
    }

    private Boolean validatePrice(){
        return !Objects.equals(price, null) && price > 0;
    }
}
