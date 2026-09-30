class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] costCache1 = new int[cost.length + 1];
        int[] costCache2 = new int[cost.length + 1];

        return Math.min(dp(0, cost, costCache1),dp(1, cost, costCache2));
    }

    private int dp(int i, int[] cost, int[] cache) {
        int l = cost.length;
        if (i >= l) return 0;
        if (i >= l - 2) return cost[i];
        if (cache[i] != 0) return cache[i];
        int temp = Math.min(dp(i + 1, cost, cache), dp(i + 2, cost, cache)) + cost[i];
        cache[i] = temp;
        return temp;
    }
}


// - Subproblem: MCCS(cost[i:]) = min Cost of last ith elements of cost
// - Relation -> MCCS(cost[i:]) =  min(
//      MCCS(cost[i + 1:]), 
//      MCCS(cost[i + 2:])
//  )
// - Topological order: increasing i
// - Base cases: MCCS(cost[-1]) = cost[-1],
//               MCCS(cost[-2]) = cost[-2]
// - Original prob: MCCS[cost[0: len(cost) - 1]]
// - Time: T(n) = T(n - 1) + T(n - 2) + O(1) > 2 T(n - 2) 
//   therefore T(n) = /omega(2^(n/2)) -> O(n^2) 
// - Subproblems: MCCS(i) more than once -> solved n - i times



