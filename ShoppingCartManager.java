package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Purchasable {
    void addItem();
    void removeItem();
    double calculateTotalPrice();
}

class Item {
    String name;
    double price;
    int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " (Price: $" + price + ", Quantity: " + quantity + ")";
    }
}

class Electronics extends Item implements Purchasable {
    public Electronics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void addItem() {
        System.out.println(quantity + " " + name + "(s) added to cart.");
    }

    @Override
    public void removeItem() {
        System.out.println(name + " removed from cart.");
    }

    @Override
    public double calculateTotalPrice() {
        return getTotalPrice();
    }
}

class Clothing extends Item implements Purchasable {
    public Clothing(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void addItem() {
        System.out.println(quantity + " " + name + "(s) added to cart.");
    }

    @Override
    public void removeItem() {
        System.out.println(name + " removed from cart.");
    }

    @Override
    public double calculateTotalPrice() {
        return getTotalPrice();
    }
}

class Bookss extends Item implements Purchasable {
    public Bookss(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void addItem() {
        System.out.println(quantity + " " + name + "(s) added to cart.");
    }

    @Override
    public void removeItem() {
        System.out.println(name + " removed from cart.");
    }

    @Override
    public double calculateTotalPrice() {
        return getTotalPrice();
    }
}

public class ShoppingCartManager {
    private List<Purchasable> cart;

    public ShoppingCartManager() {
        cart = new ArrayList<>();
    }

    public void addItem(Purchasable item) {
        item.addItem();
        cart.add(item);
    }

    public void removeItem(Purchasable item) {
        item.removeItem();
        cart.remove(item);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Purchasable item : cart) {
            total += item.calculateTotalPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Purchasable item : cart) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCartManager cartManager = new ShoppingCartManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Books");
            System.out.println("4. Remove Item");
            System.out.println("5. View Cart");
            System.out.println("6. Calculate Total Price");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Electronics Name: ");
                    String eName = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double ePrice = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int eQuantity = scanner.nextInt();
                    Purchasable electronics = new Electronics(eName, ePrice, eQuantity);
                    cartManager.addItem(electronics);
                    break;
                case 2:
                    System.out.print("Enter Clothing Name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double cPrice = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int cQuantity = scanner.nextInt();
                    Purchasable clothing = new Clothing(cName, cPrice, cQuantity);
                    cartManager.addItem(clothing);
                    break;
                case 3:
                    System.out.print("Enter Book Title: ");
                    String bName = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double bPrice = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int bQuantity = scanner.nextInt();
                    Purchasable book = new Bookss(bName, bPrice, bQuantity);
                    cartManager.addItem(book);
                    break;
                case 4:
                    System.out.print("Enter item name to remove: ");
                    String itemName = scanner.nextLine();
                    Purchasable itemToRemove = null;
                    for (Purchasable item : cartManager.cart) {
                        if (((Item) item).name.equalsIgnoreCase(itemName)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        cartManager.removeItem(itemToRemove);
                    } else {
                        System.out.println("Item not found in the cart.");
                    }
                    break;
                case 5:
                    cartManager.displayCart();
                    break;
                case 6:
                    double totalPrice = cartManager.calculateTotalPrice();
                    System.out.println("Total Price: $" + totalPrice);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
