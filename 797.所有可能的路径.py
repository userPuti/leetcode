#
# @lc app=leetcode.cn id=797 lang=python3
#
# [797] 所有可能的路径
#


# @lc code=start
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        paths = []
        target = len(graph) - 1

        def traverse(cur: int, path: List[int]):
            path.append(cur)

            if cur == target:
                paths.append(path.copy())
                path.pop()
                return

            for node in graph[cur]:
                traverse(node, path)

            path.pop()

        traverse(0, [])
        return paths


# @lc code=end
