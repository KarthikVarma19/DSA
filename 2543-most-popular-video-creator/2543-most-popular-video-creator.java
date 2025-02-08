class Solution {
    class Video{
        String id;
        int view;
        Video(String i, int v){
            id = i;
            view = v;
        }
    }
    HashMap<String, Long> popCreators;
    HashMap<String, PriorityQueue<Video>> creatorsPopVideos;

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
            creatorsPopVideos.putIfAbsent(creator, new PriorityQueue<Video>(new Comparator<Video>(){
                @Override
                public int compare(Video a, Video b){
                    if(a.view != b.view){
                        return b.view - a.view; //Sort it in Highest View Count First
                    }
                    return (a.id).compareTo(b.id); //if View's are equal Sort it lexicographically
                }
            }));
            Video newVideo = new Video(id, view);
            PriorityQueue<Video> pq = creatorsPopVideos.get(creator);
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
            String popVideo = creatorsPopVideos.get(eachCreator).peek().id;
            List<String> creator = new ArrayList<>();
            creator.add(eachCreator);
            creator.add(popVideo);
            ans.add(creator);
        }
        return ans;

    }
}