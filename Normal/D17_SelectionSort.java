
public class D17_SelectionSort {

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minData = arr[i];
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minData) {
                    minData = arr[j];
                    minIndex = j;
                }

            }

            int temp = arr[i];
            arr[i] = minData;
            arr[minIndex] = temp;

        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 90, 70, 55, 10, 5, 4 };

        arr = selectionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }

}
