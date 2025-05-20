
public class Dog {

    private String name;
    private int age;
    private String breed;
    private String color;

    public Dog(String name, int age, String breed, String color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    public void bark() {
        System.out.println(name + " is barking: Woof! Woof!");
    }

    public void spin() {
        System.out.println(name + " is spinning in circles!");
    }

    public void run() {
        System.out.println(name + " is running fast!");
    }

    public void displayDogInfo() {
        System.out.println("Dog Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Breed: " + breed);
        System.out.println("Color: " + color);
    }

    // Main method to test the Dog class
    public static void main(String[] args) {

        Dog myDog = new Dog("Buddy", 3, "Golden Retriever", "Golden");

        myDog.displayDogInfo();

        myDog.bark();
        myDog.spin();
        myDog.run();
    }
}
