
//Find the Union of Two Sorted Arrays with Duplicate Elements
//Topic: Arrays,HashMap,Sets,Two Poiter Algorithm
//Approach:-1 Use HashMap and Count Their Occurence Since Key's are Unique So You Can Iterate over keys for union TC:- O(N+M(log(N+M))) & Sc:-O(N+M)
//Approach:-2 Use Set Data Structure TC:-O((N+M)log(N+M)) & SC:-O(N+M)
//Approach:-3 As Array is Sorted Take Advantage of Two Pointers TC:- O(N+M) & SC:-O(1)
import java.util.*;

public class i {
    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 2, 3, 5, 7 };
        int arr2[] = { 1, 1, 3, 4, 7, 9 };
        approach1(arr1, arr2);
        approach2(arr1, arr2);
        approach3(arr1, arr2);
    }

    public static void approach1(int arr1[], int arr2[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }
        for (int j = 0; j < arr2.length; j++) {
            hm.put(arr2[j], hm.getOrDefault(arr2[j], 0) + 1);
        }
        for (int each : hm.keySet()) {
            ans.add(each);
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void approach2(int arr1[], int arr2[]) {
        Set<Integer> st = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            st.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            st.add(arr2[j]);
        }
        for (int ele : st) {
            ans.add(ele);
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void approach3(int arr1[], int arr2[]) {
        int i = 0, j = 0, n = arr1.length, m = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            int size = ans.size();
            if (arr1[i] <= arr2[j]) {
                if (size == 0 || ans.get(size - 1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
            } else {
                if (size == 0 || ans.get(size - 1) != arr2[j]) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            int size = ans.size();
            if (size == 0 || ans.get(size - 1) != arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            int size = ans.size();
            if (size == 0 || ans.get(size - 1) != arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }
        for (int eachEle : ans) {
            System.out.print(eachEle + " ");
        }
        System.out.println();
    }
}
