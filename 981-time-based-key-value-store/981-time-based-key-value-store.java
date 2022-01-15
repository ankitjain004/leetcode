class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        map.putIfAbsent(key, treeMap);
        treeMap =  map.get(key);
        treeMap.put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap.floorKey(timestamp)==null)return "";
        int currkey = treeMap.floorKey(timestamp);
        //if(currkey == null) return "";
        return treeMap.get(currkey);
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */