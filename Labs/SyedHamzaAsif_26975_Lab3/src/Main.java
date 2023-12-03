import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int[] numbers = IntStream.range(0, 1000).toArray();

        AlgorithmAnalysis as = new AlgorithmAnalysis();


        long searchTime = System.nanoTime();
        as.binarySearchIteration(numbers, 855);
        //as.sequentialSearch(numbers, numbers.length, 865);
        long searchTime1 = System.nanoTime();

        System.out.println(searchTime1 - searchTime);

    }
}