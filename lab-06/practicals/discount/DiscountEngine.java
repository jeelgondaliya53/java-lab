package discount;

public class DiscountEngine {

    public static DiscountRule getRule(int choice) {

        if (choice == 1) {
            return amount -> amount >= 1000 ? amount * 0.10 : 0;
        } 
        else if (choice == 2) {
            return amount -> amount >= 2000 ? amount * 0.20 : 0;
        } 
        else if (choice == 3) {
            return amount -> amount >= 3000 ? amount * 0.30 : 0;
        }

        return amount -> 0;
    }
}