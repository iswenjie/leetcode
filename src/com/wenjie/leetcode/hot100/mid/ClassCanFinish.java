package com.wenjie.leetcode.hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  207. 课程表
 * Created on 2022/1/10 14:57
 * @author iswenjie.lu
 */
public class ClassCanFinish {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        new ClassCanFinish().canFinish(5, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> conditions = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            conditions.add(new ArrayList<>());
        }
        for (int[] r : prerequisites) {
            conditions.get(r[0]).add(r[1]);
        }
        // 保存每个课程的搜索情况
        // 0为搜索;1搜索中;2搜索完成（可以上课）
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 2 || dfs(i, conditions, visited)) {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 深度优先搜索
     * @param course 当前检查的课程
     * @param conditions 所有课程需要的前置条件
     * @param visited 保存每个课程的搜索情况0为搜索1搜索中2搜索完成（可以上课）
     * @return course 课能否完成
     */
    public boolean dfs(int course, List<List<Integer>> conditions, int[] visited) {
        // 开始搜索
        visited[course] = 1;
        List<Integer> list = conditions.get(course);
        for (Integer cond : list) {
            if (visited[cond] == 1) {
                // 如果在搜索中，则表明cond在当前的课程“链”中，表明课程链存在环，死循环无法完课
                return false;
            }
            // ==2的情况说明无需判断，可以完课；==1的情况上面已经return。
            if (visited[cond] == 0) {
                if (!dfs(cond, conditions, visited)) {
                    return false;
                } else {
                    // 标记可以完课
                    visited[cond] = 2;
                }
            }
        }
        // 没有任何条件下完课(list 为空)，标记！
        visited[course] = 2;
        return true;
    }

}
