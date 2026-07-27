public class Driver {

    public static void main(String[] args) {

        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        System.out.println(f1.equals(f2));
        System.out.println(f2.equals(f3));
    }

    private static class Fraction {
        private final int numerator;
        private final int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Fraction)) {
                return false;
            }
            Fraction other = (Fraction) obj;
            return this.numerator * other.denominator == other.numerator * this.denominator;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}
