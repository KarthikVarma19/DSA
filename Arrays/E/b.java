//Second Largest Element in Array Without Sorting
//Approach:- 1 First Find the Largest Element in First Iteration & Find the Largest Element and 
            // in Second Iteration which is not Equal to First Largest Element TC:- O(n+n) & SC:- O(1)
//Approach:- 2 In Single Iteration Take Two Variables and Swap Them If The Current Element is Largest than max TC:- O(n) & SC:- O(1)
public class b {
    public static void main(String[] args) {
        int arr[] = { 1,1, 1,8,9};
        int sMax1 = getSecondLargest1(arr);
        int sMax2 = getSecondLargest2(arr);
        System.out.println(sMax1 + " " + sMax2);
    }
    public static int getSecondLargest1(int[] arr){
        int largest = -1;
        for(int each: arr){
            largest = Math.max(largest,each);
        }
        int secondLargest = -1;
        for(int sec: arr){
            if(sec>secondLargest && sec!=largest){
                secondLargest = sec;
            }
        }
        return secondLargest;
    }
    public static int getSecondLargest2(int[] arr) {
        int max = -1;
        int sMax = max;
        for (int each : arr) {
            if (each > max) {
                sMax = max;
                max = each;
            }
            else if(each>sMax && each != max){
                sMax = each;
            }
        }
        return sMax;
    }

}
