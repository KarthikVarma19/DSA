//Linear Search 
//It is Searching Algorithm Which Searches Elements in Sequential Order. It is Not Best If Array is Sorted TC:- O(n) & SC:- O(1)
public class h {
    public static void main(String[] args){
        int arr[] = {1,2,2,10,12,19};
        int key = 12;
        System.out.println("Key is Found at index: " + linearSearch(arr,key));
    }
    public static int linearSearch(int arr[], int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
