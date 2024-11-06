//Left Rotate an Array By K Elements
//Approach:-1 Take an Empty Array and Put last n-k elements in first and put first k elements at End  TC:- O(n+n) SC:- O(n)
//Approach:-2 (Reveresal Algorithm) Reverse last n-k elements and first k elements and then overall reverse the array you get the desired TC:- O(n) SC:- O(1)
public class f {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int k1 = 8; // -> {4,5,1,2,3}
        rotateArrayByK1(arr1, k1);
        printArrays(arr1);
        rotateArrayByK2(arr1, k1);
        printArrays(arr1);
    }

    public static void rotateArrayByK1(int[] arr, int k) {
        int temp[] = new int[arr.length];
        k = k % arr.length;
        // Put Last n-k Elements at Start
        for (int i = 0; i < arr.length - k; i++) {
            temp[i] = arr[arr.length - k + 1 + i];
        }
        // Put First K Elements at End
        for (int j = arr.length - k; j < arr.length; j++) {
            temp[j] = arr[j - k + 1];
        }
        // Replace Original Array Elements
        for (int l = 0; l < arr.length; l++) {
            arr[l] = temp[l];
        }
    }

    public static void printArrays(int arr[]) {
        for (int each : arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

    public static void rotateArrayByK2(int arr[], int k) {
        // Reversal Algorithm
        int n = arr.length;
        k = k % n;
        reverse(arr, n - k + 1, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
