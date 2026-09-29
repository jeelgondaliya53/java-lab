abstract class Media {
    String name;

    Media(String name) {
        this.name = name;
    }

    abstract double calculateFine(int daysLate);
}

class Novel extends Media {

    Novel(String name) {
        super(name);
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate*4;
    }
}

class Movie extends Media {

    Movie(String name) {
        super(name);
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate*8;
    }
}

class Journal extends Media {

    Journal(String name) {
        super(name);
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 2;
    }
}

public class Mediamain {
    public static void main(String[] args) {

        Media[] it={
            new Novel("Housemaid"),
            new Movie("Spiderman:Brand New day"),
            new Journal("Vogue"),
            new Novel("Harry Potter")
        };

        int[] lateDays = {3, 2, 5, 4};

        double totalFine = 0;

        for (int i=0;i<it.length;i++) {

            double fine = it[i].calculateFine(lateDays[i]);

            System.out.println(it[i].name +" \nDays late: " + lateDays[i] +" \nFine: " + fine);
            System.out.println("----------------------");
            totalFine += fine;
        }

        System.out.println("----------------------");
        System.out.println("Total Fine:" + totalFine);
    }
}