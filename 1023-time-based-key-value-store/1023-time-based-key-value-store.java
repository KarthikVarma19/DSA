class TimeMap {
    HashMap<String,TreeMap<Integer,String>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key, new TreeMap<>());     
        }
        TreeMap<Integer,String> tmap = hm.get(key);
        tmap.put(timestamp,value);
        hm.put(key,tmap);
    }
    
    public String get(String key, int timestamp) {
        if(hm.containsKey(key)){
            TreeMap<Integer,String> tmap = hm.get(key);
            Integer floorKey = tmap.floorKey(timestamp);
            if(floorKey == null){
                return "";
            }
            String ans = tmap.get(floorKey);
            return ans;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */