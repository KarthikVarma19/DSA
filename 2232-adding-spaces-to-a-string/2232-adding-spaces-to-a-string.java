class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int increment = 0;
        for(int place: spaces){
            sb.insert(place + increment, " ");
            increment++;
        }
        return sb.toString();
    }
}