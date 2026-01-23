// package Normal;

class Search {

    boolean linearSearch(int[] arr, int data) {
        boolean isFound = false;
        for (int i : arr) {
            if (arr[i] == data) {
                isFound = true;
            }
        }

        return isFound;

    }

    

}

public class D14_LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };

        Search s = new Search();
 

    }
}
