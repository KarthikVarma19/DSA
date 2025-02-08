class Solution {
    class Video implements Comparable<Video> {
        String id;
        int view;
        Video(String i, int v){
            id = i;
            view = v;
        }
        @Override
        public int compareTo(Video a){
            if(a.view != this.view){
                return a.view - this.view; //Sort it in Highest View Count First
            }
            return (this.id).compareTo(a.id); //if View's are equal Sort it lexicographically
        }
    }
    HashMap<String, Long> popCreators;
    HashMap<String, TreeSet<Video>> creatorsPopVideos;

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        popCreators = new HashMap<>();
        creatorsPopVideos = new HashMap<>();

        //Inserting Video's as Per Need
        for(int i = 0; i < n; i++){
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            popCreators.put(creator, popCreators.getOrDefault(creator, (long)0) + view);
            creatorsPopVideos.putIfAbsent(creator, new TreeSet<>());
            Video newVideo = new Video(id, view);
            TreeSet<Video> pq = creatorsPopVideos.get(creator);
            pq.add(newVideo);
        }

        //Retreving Popular Video Creator's
        ArrayList<String> creatorsList =  new ArrayList<>();
        long mostViews = -1;
        for(Map.Entry<String, Long> entry: popCreators.entrySet()){
            String key = entry.getKey();
            long value = entry.getValue();
            if(value > mostViews){
                creatorsList = new ArrayList<>();
                creatorsList.add(key);
                mostViews = value;
            }
            else if(value == mostViews){
                creatorsList.add(key);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String eachCreator: creatorsList){
            String popVideo = creatorsPopVideos.get(eachCreator).first().id;
            List<String> creator = new ArrayList<>();
            creator.add(eachCreator);
            creator.add(popVideo);
            ans.add(creator);
        }
        return ans;

    }
}