public class Problem2 {

    public void myFunc(int[] A, int N) {
        AlgorithmAnalysis as = new AlgorithmAnalysis();
        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            as.binarySearchIteration(A, N);
            for (int j = 0; j < N; j++) {
                count++;
                for (int k = 0; k < N; k++) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
