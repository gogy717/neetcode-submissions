class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = position.size();
        vector<pair<int,int>> cars(n);
        for (int i = 0; i < n; i++)
            cars[i] = {position[i], speed[i]};
        sort(cars.begin(), cars.end());

        int fleet_cnt = 0;
        float min_time = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            float time = (float)(target - cars[i].first) / cars[i].second;
            if (time > min_time) {
                min_time = time;
                fleet_cnt++;
            } 
            
        }
        return fleet_cnt;
    }
};
