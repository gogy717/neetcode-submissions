class Solution {
public:
    int trap(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int l_max = 0, r_max = height.size() -1;
        int volume = 0; 
        int is_left = false, is_right = false;

        while (l < r) {
            if (is_left){
                volume += max(height[l_max] - height[l], 0);
                is_left = false;
            }
                
            if (is_right) {
                volume += max(height[r_max] - height[r], 0);
                is_right = false;
            }

            if (height[l] > height[l_max]) {
                l_max = l;
            }
            if (height[r] > height[r_max]) {
                r_max = r;
            }
            if (height[l] < height[r]) {
                l ++;
                is_left = true;

            }else {
                r --;
                is_right = true;
            }
        }
        return volume;
    }
};
