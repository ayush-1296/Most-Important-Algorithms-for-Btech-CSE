
public class FibonacciSearch {

    public static int fibonacciSearch(int[] integers, int elementToSearch) {

        int fibonacciMinus2 = 0;
        int fibonacciMinus1 = 1;
        int fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        int arrayLength = integers.length;

        while (fibonacciNumber < arrayLength) {
            fibonacciMinus2 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciNumber;
            fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        }

        int offset = -1;

        while (fibonacciNumber > 1) {
            int i = Math.min(offset+fibonacciMinus2, arrayLength-1);

            if (integers[i] < elementToSearch) {
                fibonacciNumber = fibonacciMinus1;
                fibonacciMinus1 = fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
                offset = i;
            }

            else if (integers[i] > elementToSearch) {
                fibonacciNumber = fibonacciMinus2;
                fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
            }

            else return i;
        }

        if (fibonacciMinus1 == 1 && integers[offset+1] == elementToSearch)
            return offset+1;

        return -1;
    }


    public static void main(String[] args) {
        int index = fibonacciSearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 67);
        System.out.println(String.format("Index of %s: %s"67, index));
    }
}
