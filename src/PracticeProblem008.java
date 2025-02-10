
abstract class Restaurant {
    protected String name;
    protected double foodPrice;
    protected static final double STANDARD_TAX = 0.10;

    public Restaurant(String name, double foodPrice) {
        this.name = name;
        this.foodPrice = foodPrice;
    }

    public double calculateTotalBill() {
        return foodPrice + (foodPrice * STANDARD_TAX);
    }

    public int estimateDeliveryTime() {
        return 40;
    }
}

class FastFoodRestaurant extends Restaurant {
    private static final double FAST_FOOD_TAX = 0.15;

    public FastFoodRestaurant(String name, double foodPrice) {
        super(name, foodPrice);
    }

    @Override
    public double calculateTotalBill() {
        return foodPrice + (foodPrice * FAST_FOOD_TAX);
    }

    @Override
    public int estimateDeliveryTime() {
        return 20;
    }
}

// Fine Dining Restaurant subclass
class FineDiningRestaurant extends Restaurant {
    public FineDiningRestaurant(String name, double foodPrice) {
        super(name, foodPrice);
    }

    @Override
    public int estimateDeliveryTime() {
        return 60;
    }
}

public class PracticeProblem008 {
    public static void main(String[] args) {
        Restaurant standardRestaurant = new Restaurant("General Eatery", 100) {
        };
        Restaurant fastFood = new FastFoodRestaurant("Quick Bites", 100);
        Restaurant fineDining = new FineDiningRestaurant("Luxury Feast", 100);

        System.out.println("Standard Restaurant Bill: " + standardRestaurant.calculateTotalBill() + ", Delivery Time: " + standardRestaurant.estimateDeliveryTime() + " mins");
        System.out.println("Fast Food Bill: " + fastFood.calculateTotalBill() + ", Delivery Time: " + fastFood.estimateDeliveryTime() + " mins");
        System.out.println("Fine Dining Bill: " + fineDining.calculateTotalBill() + ", Delivery Time: " + fineDining.estimateDeliveryTime() + " mins");
    }
}