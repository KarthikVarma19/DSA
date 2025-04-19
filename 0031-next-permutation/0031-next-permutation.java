class Solution {
    public void nextPermutation(int[] arr) {
        // Bruteforce 
        // Generate all the permutations 
        // I will store all the permutation in an sorted container 
        // I will Do a Linear Search on the contiainer to find the given array 
        // I will return or reset with the next permutation of the found one ....
        // Time Complexity:- O(n! * n)
        // Can Be Solved using Recursion & Backtracking .... 
        // Let's now go into another approach 
        // using two pointers 
        // An Observation to be seen is 
        // 1) Need to find an break point where next element is greater than current 
        int n = arr.length;
        int ind = -1;
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            sort(arr, 0, n-1);
            return;
        }
        // 2) In the Rest of the elements from the break point we will be looking the next greater element and swaping it 
        for(int i = n-1; i > ind; i--){
            if(arr[i] > arr[ind]){
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }
        // 3) Sort the Array from the breakpoint to the end of the array 
        sort(arr, ind+1, n-1);
    }
    public void sort(int arr[], int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}