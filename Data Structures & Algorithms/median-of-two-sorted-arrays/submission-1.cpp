class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // 保证在较短数组上二分，才能做到 O(log(min(m,n)))
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.size(), n = nums2.size();
        int half = (m + n + 1) / 2;   // 左半边应有的元素个数

        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;   // nums1 左边取 i 个
            int j = half - i;             // nums2 左边取 j 个，随 i 自动确定

            int left1  = (i == 0) ? INT_MIN : nums1[i - 1];
            int right1 = (i == m) ? INT_MAX : nums1[i];
            int left2  = (j == 0) ? INT_MIN : nums2[j - 1];
            int right2 = (j == n) ? INT_MAX : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                // 切割合法
                if ((m + n) % 2 == 0) {
                    return (max(left1, left2) + min(right1, right2)) / 2.0;
                } else {
                    return max(left1, left2);
                }
            } else if (left1 > right2) {
                hi = i - 1;   // A 左边太大 -> i 变小
            } else {
                lo = i + 1;   // B 左边太大 -> i 变大
            }
        }
        return 0.0; // 逻辑上走不到这里
    }
};