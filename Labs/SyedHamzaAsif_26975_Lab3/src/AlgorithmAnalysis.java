public class AlgorithmAnalysis {

    public int sequentialSearch(int arr[], int N, int num){
        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            if (arr[i] == num){
                //System.nanoTime();
                System.out.println(count);
                return i;
            }
        }
        return -1;
    }
    public int binarySearchIteration(int arr[], int num){
        int count = 0;

        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;

        while (first < last){
            count++;
            if (arr[mid] > num) {
                count++;
                last = mid - 1;
            }
            else if (arr[mid] == num) {
                count++;
                //System.nanoTime();
                System.out.println(count);
                return mid;
            }
            else
                first = mid + 1;
            mid = (first + last) / 2;
        }
        if (arr[mid] == num) {
            count++;
            //System.nanoTime();
            System.out.println(count);
            return mid;
        }
        else return -1;
    }
}

