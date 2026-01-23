public class D18_InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) { //

            for (int j = i; j >= 1; j--) { // i =3 ; d=2 , j=2

                if (arr[j] < arr[j - 1]) { // arr j = 2 , arr j-1 = 4
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

                else {
                    break;
                }

            }

        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 2, 1 };

        arr = insertionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
