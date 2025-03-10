class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for(int i = 0; i < fruits.length; i++){
            int fruit = fruits[i];
            for(int j = 0; j < baskets.length; j++){
                if(baskets[j] >= fruit){
                    count++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return fruits.length-count;
    }
}