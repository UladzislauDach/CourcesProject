package lesson1.task2;

public class MainCar {
    public static void main(String[] args) {
        CarPart[] carParts = new CarPart[2];
        carParts[0] = new Engine("2jz", "3.0 turbo");
        carParts[1] = new Engine("2gr-fse", "3.5 combine fuel injection");

        for (CarPart carPart : carParts){
            System.out.println(carPart.toString());
        }
    }
}
