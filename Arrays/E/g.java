
//Move Zeros To End 
//Approach:-1 Take an ArrayList and Add Only Non-Zero Elements and Replace With First Non-Zero Elements and Remaining With Zeros TC:- O(n+n) SC:- O(n)
//Approach:-2 Two Pointers Approach One Pointer at Zero and Another Pointer at Non-Zero TC:- O(n) SC:- O(1)
import java.util.ArrayList;

public class g {
    public static void main(String[] args) {
        int arr1[] = { 1, 0, 2, 3, 0, 4, 0, 1 };
        moveZerosEnd1(arr1); // 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
        printArray(arr1);
        int arr2[] = { 1, 2, 0, 1, 0, 4, 0 };
        moveZerosEnd2(arr2); // 1,2,1,4,0,0,0
        printArray(arr2);
    }

    public static void moveZerosEnd1(int arr[]) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int each : arr) {
            if (each != 0) {
                al.add(each);
            }
        }
        for (int j = 0; j < al.size(); j++) {
            arr[j] = al.get(j);
        }
        for (int i = al.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void moveZerosEnd2(int arr[]) {
        int i = 0, j = 0, n = arr.length;
        while (j < n) {
            if (arr[i] != 0 && arr[j] != 0) {
                i++;
            } else if (arr[i] == 0 && arr[j] != 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
            }
            j++;
        }
    }

    public static void printArray(int arr[]) {
        for (int each : arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }
}
