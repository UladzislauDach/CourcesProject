package lesson1.task2;

public class Engine implements CarPart{
    private String name;
    private String description;

    public Engine(String name, String description) {
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
        return "Engine name= " + getName() + " description= " + getDescription();
    }
}
