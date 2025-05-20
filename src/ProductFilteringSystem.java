public class ProductFilteringSystem {


    public void filterProducts(String category) {
        System.out.println("Filtering products by category: " + category);
    }

    public void filterProducts(double minPrice, double maxPrice) {
        System.out.println("Filtering products by price range: $" + minPrice + " - $" + maxPrice);
    }

    public void filterProducts(String brand, boolean Brand) {
        System.out.println("Filtering products by brand: " + brand);
    }

    public void filterProducts(String category, double minPrice, double maxPrice) {
        System.out.println("Filtering products by category: " + category + " and price range: $" + minPrice + " - $" + maxPrice);
    }

    public void filterProducts(String category, double minPrice, double maxPrice, String brand) {
        System.out.println("Filtering products by category: " + category + ", price range: $" + minPrice + " - $" + maxPrice + ", and brand: " + brand);
    }

    public static void main(String[] args) {
        ProductFilteringSystem system = new ProductFilteringSystem();

        system.filterProducts("electronics");
        system.filterProducts(100, 500);
        system.filterProducts("Apple", true);
        system.filterProducts("fashion", 50, 200);
        system.filterProducts("electronics", 100, 500, "Samsung");
    }
}
