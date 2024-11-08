/*
 * Q) Max Consecutive Ones
   Given a binary array nums, return the maximum number of consecutive 1's in the array.
   Topics:= Arrays,Counting
 */
//Approach:-1 Nested Loops TC:- O(N*N) & SC:- O(1)
//Approach:- 2 Using Max Variable TC:- O(N) & SC:- O(1)
public class k {
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        approach1(arr);
        approach2(arr);
    }
    public static void approach1(int arr[]){
        int maxCount = 0;
        for(int i=0;i<arr.length;i++){
            int count = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[j] == 0){
                    break;
                }
                count++;
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
    public static void approach2(int arr[]){
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                sum = 0;
            }
            else{
                sum++;
            }
            maxSum = Math.max(maxSum,sum);
        }
        System.out.println(maxSum);
    }
}
