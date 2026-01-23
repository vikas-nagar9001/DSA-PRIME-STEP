public class D16_BubbleSort {

    public static int[] bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean check = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    check = true;
                }

            }

            if (check == false) {
                break;
            }
        }

        return arr;

    }

    public static void main(String[] args) {

        int[] arr = { 766, 22, 45, 565, 656, 65, 43, 23,5 };

        arr = bubbleSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
