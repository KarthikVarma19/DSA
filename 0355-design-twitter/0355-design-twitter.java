class Twitter {
    class Tweet implements Comparable<Tweet>{
        int timeStamp;
        int tweetId;
        Tweet(int ts, int tid){
            timeStamp = ts;
            tweetId = tid;
        }
        public int compareTo(Tweet that){
            return that.timeStamp-this.timeStamp;
        }
    }
    class User{
        int userId;
        HashSet<Integer> followers;
        List<Tweet> tweets;
        User(int u){
            userId = u;
            followers = new HashSet<>();
            followers.add(u); //adding self follow
            tweets = new LinkedList<>();
        }
        public void addFollower(int followeeId){
            followers.add(followeeId);
        }
        public void removeFollower(int followeeId){
            followers.remove(followeeId);
        }
        public void addTweet(Tweet t){
            tweets.add(0,t); //Adding Tweet At Head in a Linkedlist
        }
    }
    int timeStamp;
    HashMap<Integer,User> userMap;
    public Twitter() {
        timeStamp = 0;
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User u = userMap.get(userId);
        u.addTweet(new Tweet(timeStamp,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User u = userMap.get(userId);
        for(Integer follower: u.followers){
            int count = 0;
            for(Tweet tweet: userMap.get(follower).tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index<10){
            feed.add(pq.peek().tweetId);
            pq.remove();
            index++;
        }
        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User u = userMap.get(followerId);
        u.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }
        User u = userMap.get(followerId);
        u.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */