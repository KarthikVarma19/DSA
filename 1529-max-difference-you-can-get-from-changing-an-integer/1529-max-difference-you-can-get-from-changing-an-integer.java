class Solution {
    public int maxDiff(int num) {
        String maxNumber = Integer.toString(num);
        String minNumber = Integer.toString(num);
        for(int i = 0; i < maxNumber.length(); i++){
            if(maxNumber.charAt(i) != '9'){
                maxNumber = maxNumber.replace(maxNumber.charAt(i), '9');
                break;
            }
        }
        for(int i = 0; i < minNumber.length(); i++){
            if(i == 0){
                if(minNumber.charAt(i) != '1'){
                    minNumber = minNumber.replace(minNumber.charAt(i), '1');
                    break;
                }
            }else {
                if(minNumber.charAt(i) != '0' && minNumber.charAt(0) != minNumber.charAt(i)){
                    minNumber = minNumber.replace(minNumber.charAt(i), '0');
                    break;
                }
            }
        }
        return Integer.parseInt(maxNumber) - Integer.parseInt(minNumber);
    }
}