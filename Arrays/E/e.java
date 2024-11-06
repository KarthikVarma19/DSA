//Left Rotate an Array By One Place
//Approach:-1 Take another Array and Store All The Elements In Their Correct Place and Store The Last Element in 0th Index of New Array TC:- O(n) & SC:- O(n)
//Approach:-2 Take a Temp variable Store the Last Element and Replace Next Element With Current Element TC:- O(n) & SC:- O(1)
public class e {
    public static void main(String[] args) {
        int arr[] = { 1 , 2, 3, 4, 5 }; // {2,3,4,5,1}
        int arr1[] = { 4, 5, 6, 7, 8 }; // {5,6,7,8,4}
        leftRotate1(arr);
        leftRotate2(arr1);
        printArray(arr1);
    }
    public static void leftRotate1(int arr[]){
        int temp[] = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            temp[i] = arr[i+1];
        }
        temp[arr.length-1] = arr[0];
        printArray(temp);
    }
    public static void leftRotate2(int arr[]){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
    }
    public static void printArray(int arr[]){
        for(int each: arr){
            System.out.print(each + " ");
        }
        System.out.println();
    }
}
