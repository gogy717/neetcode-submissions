class Solution {
public:
    int maxArea(vector<int>& heights) {
        int l = 0, r = heights.size() - 1;
        int max_volume = 0;
        while (l < r) {
            int volume = (r - l) * min(heights[l], heights[r]);
            max_volume = max(volume, max_volume);
            
            if (heights[l] > heights[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return max_volume;
    }
};
