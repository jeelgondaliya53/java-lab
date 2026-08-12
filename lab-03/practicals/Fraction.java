import java.util.*;

public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        int g=gcd(num, den);
        this.num=num / g;
        this.den=den / g;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o)
            return true;

        if (!(o instanceof Fraction))
            return false;

        Fraction f=(Fraction) o;
        return num==f.num && den==f.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num,den);
    }
}