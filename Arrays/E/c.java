//Check if Array is Sorted
//Approach:- 1 Nested Loops(Bubble Sort Type) TC:- O(N^2) & SC:- O(1)
//Approach:- 2 Simply Check With Previous Element TC:- O(N) & SC:- O(1)
//Approach:- 3 Let Recursion Take Care Bro  TC:- O(N) & SC:- O(N)Recursive Stack Space
public class c {
    public static void main(String[] args) {
        int arr[] = { 1, -1, 1, 1, 1 };
        boolean flag1 = isSorted1(arr);
        boolean flag2 = isSorted2(arr);
        boolean flag3 = isSorted3(arr, 0);
        System.out.println(flag1 + " " + flag2 + " " + flag3);
    }

    public static boolean isSorted1(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean isSorted2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted3(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        boolean flag = isSorted3(arr, index + 1);
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return flag;
    }
}
