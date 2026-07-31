class Twitter {
private:
    unordered_map<int, unordered_set<int>> followMap;
    unordered_map<int, vector<pair<int,int>>> tweetMap; 
    int timestamp = 0; 
public:
    Twitter() {
        timestamp = 0;
    }
    
    void postTweet(int userId, int tweetId) {
        this->tweetMap[userId].push_back(pair(timestamp, tweetId));
        timestamp++;
    }
    
    vector<int> getNewsFeed(int userId) {
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        followMap[userId].insert(userId);   // 把自己也当成"关注的人",省事
        for (int followeeId : followMap[userId]) {
            for (pair<int, int> tweet : tweetMap[followeeId]) {
                pq.push({tweet.first, tweet.second});
                if (pq.size() > 10) {
                    pq.pop();
                }
            }
        }
        vector<int> result;
        while (!pq.empty()) {
            result.push_back(pq.top()[1]);
            pq.pop();
        }
        reverse(result.begin(), result.end());   // 加这一行,需要 #include <algorithm>
        return result;
    }
    
    void follow(int followerId, int followeeId) {
        this->followMap[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        this->followMap[followerId].erase(followeeId);
    }
};
