
import java.util.Arrays;

/*
Q) Find the Missing Number in a Array 
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
 */
//Topics: Arrays,Linear Search, Sorting, Hashing, Maths(Sum of N Natural Numbers), Xor Property
//Approach:-1 Check For Presence of Each Element in the Array (Linear Search) Nested Loops TC:- O(N*N)  & SC:- O(1)
//Approach:-2 Sort The Array and Check if index and element in the index is same or not  TC:- O(NlogN + M) & SC:- O(1)
//Approach:-3 Hashing Marking If The Element is present or not TC:- O(2*N) & SC:- O(N)
//Approach:-4 Using Summation Approach Sum of N Natural Numbers TC:- O(N) & Sc:-O(1)
//Approach:-5 Using Xor Property TC:- O(2N) & SC:- O(1)
public class j {
    public static void main(String[] args) {
        int arr[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        approach1(arr);
        approach3(arr);
        approach4(arr);
        approach5(arr);
        approach2(arr);
    }

    public static void approach1(int arr[]) {
        for (int i = 0; i <= arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void approach2(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] != i) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void approach3(int arr[]) {
        int hash[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int j = 0; j < arr.length; j++) {
            if (hash[j] == 0) {
                System.out.println(j);
                break;
            }
        }
    }

    public static void approach4(int arr[]) {
        int n = arr.length;
        int summation = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            summation -= arr[i];
        }
        System.out.println(summation);
    }

    public static void approach5(int arr[]) {
        int xor1 = 0;
        for (int i = 0; i <= arr.length; i++) {
            xor1 = xor1 ^ i;
        }
        int xor2 = 0;
        for (int j = 0; j < arr.length; j++) {
            xor2 = xor2 ^ arr[j];
        }
        System.out.println(xor1 ^ xor2);
    }
}
