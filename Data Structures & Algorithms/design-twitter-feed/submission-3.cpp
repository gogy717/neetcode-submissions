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
        priority_queue<vector<int>> pq;   // 最大堆:{timestamp, tweetId, userId, index}
        followMap[userId].insert(userId);
        
        // 第一步:每个人只放【最新的一条】进堆
        for (int followeeId : followMap[userId]) {
            auto& tweets = tweetMap[followeeId];
            if (!tweets.empty()) {
                int idx = tweets.size() - 1;   // 最后一条 = 最新
                pq.push({tweets[idx].first, tweets[idx].second, followeeId, idx});
            }
        }
        
        // 第二步:弹 10 次,每弹一条就补这个人的下一条(更旧的)
        vector<int> result;
        while (!pq.empty() && result.size() < 10) {
            vector<int> top = pq.top();
            pq.pop();
            result.push_back(top[1]);        // top[1] = tweetId
            
            int followeeId = top[2];
            int idx = top[3];
            if (idx > 0) {                   // 这个人还有更旧的推
                idx--;
                auto& tweets = tweetMap[followeeId];
                pq.push({tweets[idx].first, tweets[idx].second, followeeId, idx});
            }
        }
        return result;
    }
    
    void follow(int followerId, int followeeId) {
        this->followMap[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        this->followMap[followerId].erase(followeeId);
    }
};
