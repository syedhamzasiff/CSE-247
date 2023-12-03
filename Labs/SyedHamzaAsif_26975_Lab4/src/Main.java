public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 3, 13, 14, 19};
        System.out.println(findMax(arr, arr.length));

        System.out.println(power(6,2));

        printPattern(17);
    }

    public static int findMax(int array[], int n) {
        if (n == 0)
            return array[0];
        return Math.max(array[n-1], findMax(array, n-1));
    }

    public static int power(int base, int powerRaised) {
        if (powerRaised == 0)
            return 1;
        if (powerRaised == 1)
            return base;
        return base*power(base,powerRaised-1);
    }

    public static void printPattern(int n) {
        if (n==0)
            return;

        for (int i = 0; i < n; i++)
            System.out.print("*");

        System.out.println();
        printPattern(n-1);

        for (int i = 0; i < n; i++)
            System.out.print("*");

        System.out.println();
    }

    public void Tower(int n, char from, char to, char aux){
        if (n>0){
            Tower(n-1, from, aux, to);
            System.out.println(from+ "-"+ to);
            Tower(n-1, aux, to, from);
        }
    }


}
