class TimeMap {
private:
    int timestamp;
    int value;
    unordered_map<string, vector<pair<int, string>>> store;

public:
    TimeMap() {}
    
    void set(string key, string value, int timestamp) {
        store[key].emplace_back(timestamp, value);
    }
    
    string get(string key, int timestamp) {
        auto it = store.find(key);
        if (it == store.end()) return "";

        vector<pair<int, string>> & history = it->second;
        
        int l = 0, r = (int)history.size() - 1;
        string ans = "";
        while(l <= r) {
            int mid = (l + r) / 2;
            if (history[mid].first <= timestamp) {
                ans = history[mid].second;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return ans;
    }
};
