
//Largest Element In a Array
//Approach:- 1 Sort The Array And Return The Last Element TC:- O(nlogn) SC:- O(1)
//Approach:- 2 Take a Max Element And Iterate Through Array and Update the Max Value If Current is Max TC:- O(n) SC:- O(1)
//Approach:- 3 Recursive Approach :- TC:- O(n) && SC:- O(n) Stack Space
import java.util.Arrays;

class a {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 1999, 111, 1, 3, 0 };

        int largest1 = getLargest1(arr);
        int largest2 = getLargest2(arr);
        int largest3 = getLargest3(arr, 0);
        System.out.println(largest1 + " " + largest2 + " " + largest3);
    }

    public static int getLargest1(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    public static int getLargest2(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int each : arr) {
            max = Math.max(max, each);
        }
        return max;
    }

    public static int getLargest3(int arr[], int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int largest = getLargest3(arr, index + 1);
        if (largest > arr[index]) {
            return largest;
        }
        return arr[index];
    }
}