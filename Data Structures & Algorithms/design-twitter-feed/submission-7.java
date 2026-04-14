

class Twitter {
    Map<Integer, List<Integer>> userTweets;
    Map<Integer, Integer> tweetTime;
    Map<Integer, List<Integer>> userFollowers;
    int timeCounter = 0;
    int k = 10;
    public Twitter() {
        this.userTweets = new HashMap<>();
        this.tweetTime = new HashMap<>();
        this.userFollowers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.userTweets.putIfAbsent(userId, new ArrayList<>());
        this.userTweets.get(userId).add(tweetId);
        this.timeCounter++;
        this.tweetTime.put(tweetId, this.timeCounter);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(  (a, b) -> { return (b[1] - a[1]); });
        ArrayList<Integer> followeeIds = new ArrayList<>(this.userFollowers.getOrDefault(userId, new ArrayList<>()));
        followeeIds.add(userId);
        for (Integer followeeId : followeeIds) {
            for (Integer tweetId : this.userTweets.getOrDefault(followeeId, new ArrayList<>())) {
                int[] tweet = new int[]{tweetId, this.tweetTime.get(tweetId)};
                pq.offer(tweet);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < k) {
            result.add(pq.poll()[0]);
            count ++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        this.userFollowers.putIfAbsent(followerId, new ArrayList<>());
        if (!this.userFollowers.get(followerId).contains(followeeId)){ 
        this.userFollowers.get(followerId).add(followeeId);}
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (this.userFollowers.containsKey(followerId)) {
            this.userFollowers.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}