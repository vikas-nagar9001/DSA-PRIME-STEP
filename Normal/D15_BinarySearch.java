public class D15_BinarySearch {
     public static boolean binarySearch(int[] arr, int data) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == data) {
                System.out.println("Data Found at index: " + mid);
                return true;
            } else if (data > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found");
        return false;
    }
    public static void main(String[] args) {
      
         int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };

         binarySearch(arr, 40);
    }
    
}
