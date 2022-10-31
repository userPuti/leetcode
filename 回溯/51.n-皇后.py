#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N 皇后
#


# @lc code=start
class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.'] * n for _ in range(n)]

        res = []

        def isValid(x: int, y: int) -> bool:
            for i in range(x):
                if board[i][y] == 'Q':
                    return False

            for i, j in zip(range(x - 1, -1, -1), range(y - 1, -1, -1)):
                if board[i][j] == 'Q':
                    return False

            for i, j in zip(range(x - 1, -1, -1), range(y + 1, n, 1)):
                if board[i][j] == 'Q':
                    return False

            return True

        def backtrack(row: int):
            if row == n:
                temp = [''.join(i) for i in board]
                res.append(temp)
                return

            for col in range(n):
                if not isValid(row, col):
                    continue

                board[row][col] = 'Q'
                backtrack(row + 1)
                board[row][col] = '.'

        backtrack(0)
        return res

# @lc code=end
