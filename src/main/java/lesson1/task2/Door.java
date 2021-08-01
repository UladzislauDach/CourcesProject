package lesson1.task2;

public class Door implements CarPart{
    private String name;
    private String description;

    public Door(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Door name= " + getName() + " description= " + getDescription();
    }
}
