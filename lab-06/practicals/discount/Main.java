package discount;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of prices: ");
        int n = sc.nextInt();

        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price: ");
            prices.add(sc.nextDouble());
        }

        double total = 0;

        for (double price : prices) {
            total += price;
        }

        System.out.println("\nTotal Spent: ₹" + total);

        System.out.println("\nChoose Discount Rule:");
        System.out.println("1. Spend ₹1000 or more -> 10% discount");
        System.out.println("2. Spend ₹2000 or more -> 20% discount");
        System.out.println("3. Spend ₹3000 or more -> 30% discount");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        DiscountRule rule = DiscountEngine.getRule(choice);

        double discount = rule.apply(total);
        double finalAmount = total - discount;

        System.out.println("\nTotal Spent: ₹" + total);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Amount: ₹" + finalAmount);

        sc.close();
    }
}