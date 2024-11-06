
//Remove Duplicates From The Sorted Array
//Approach:- 1 Use A Set DataStructures Which Stores Only Unique Elements and 
//Replace First SetLength Elements in Original Array TC:- O(n+n) & SC:- O(n)
//Approach:- 2 Use Two Pointer Technique Since Arrays is Sorted TC:- O(n) & SC:- O(1)
import java.util.*;

public class d {
    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 3, 3 }; // -> {1,2,3,_,_};
        int arr2[] = { 2, 4, 5, 5, 9, 10, 10 }; // ->{2,4,5,9,10,_,_};

        removeDupli1(arr1);
        removeDupli2(arr2);
        printArray(arr1);
        printArray(arr2);
    }

    public static void removeDupli1(int[] arr) {
        Set<Integer> st = new TreeSet<>();
        for (int each : arr) {
            st.add(each);
        }
        int i = 0;
        for (int x : st) {
            arr[i++] = x;
        }
    }

    public static void removeDupli2(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int each : arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }
}
