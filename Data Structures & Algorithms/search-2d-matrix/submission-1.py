class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        up, down = 0, len(matrix) - 1
        mid = (up + down)// 2
        while up <= down:
            if matrix[mid][0] < target:
                up = mid + 1
            elif matrix[mid][0] > target:
                down = mid - 1
            elif matrix[mid][0] == target:
                return True
            mid = (up + down)// 2

        l, r = 0, len(matrix[0]) - 1
        m = (l + r)// 2
        while l <= r:
            if matrix[mid][m] < target:
                l = m + 1
            elif matrix[mid][m] > target:
                r = m - 1
            elif matrix[mid][m] == target:
                return True
            m = (l + r)// 2

        return False

        