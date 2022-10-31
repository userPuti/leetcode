#
# @lc app=leetcode.cn id=232 lang=python3
#
# [232] 用栈实现队列
#

# @lc code=start


class MyQueue:

    def __init__(self):
        self.list = []

    def push(self, x: int) -> None:
        self.list.append(x)

    def pop(self) -> int:
        ans = self.list[0]
        self.list = self.list[1:]
        return ans

    def peek(self) -> int:
        return self.list[0]

    def empty(self) -> bool:
        if len(self.list) == 0:
            return True
        else: 
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# @lc code=end

