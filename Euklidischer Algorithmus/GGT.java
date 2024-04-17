public class GGT {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a <= 0 || b <= 0) {
            System.out.println("Die eingegebenen Zahlen müssen echt positiv (> 0) sein.");
            System.exit(-1);
        }

        int m = a;
        int n = b;

        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }

        System.out.println("ggT(" + a + ", " + b + ") = " + m);
    }
}