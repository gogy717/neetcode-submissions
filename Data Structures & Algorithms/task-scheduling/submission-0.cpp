class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int cnts[26] = {0};
        for (char c : tasks) {
            cnts[c - 'A']++;
        }
        int max_count = 0, count_max = 0;
        for (int i : cnts) {
            max_count = max(max_count, i);
        }        
        for (int i : cnts) {
            if (max_count == i) {
                count_max++;
            }
        }
        int skeleton = (max_count - 1) * n + max_count;

        return max(skeleton + count_max-1, (int)tasks.size());
    }
};
