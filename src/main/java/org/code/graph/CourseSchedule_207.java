package org.code.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule_207 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        System.out.println(new CourseSchedule_207().canFinish(numCourses, prerequisites));
    }

    /**
     * BFS 方式
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    public boolean canFinishWithBFS(int numCourses, int[][] prerequisites) {
        //保存每个节点的先修课个数，也就是出度
        HashMap<Integer, Integer> outNum = new HashMap<>();
        //保存以 key 为先修课的列表，也就是入度的节点
        HashMap<Integer, ArrayList<Integer>> inNodes = new HashMap<>();
        //保存所有节点
        HashSet<Integer> set = new HashSet<>();
        int rows = prerequisites.length;
        for (int i = 0; i < rows; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            set.add(key);
            set.add(value);
            if (!outNum.containsKey(key)) {
                outNum.put(key, 0);
            }
            if (!outNum.containsKey(value)) {
                outNum.put(value, 0);
            }
            //当前节点先修课个数加一
            int num = outNum.get(key);
            outNum.put(key, num + 1);

            if (!inNodes.containsKey(value)) {
                inNodes.put(value, new ArrayList<>());
            }
            //更新以 value 为先修课的列表
            ArrayList<Integer> list = inNodes.get(value);
            list.add(key);
        }

        //将当前先修课个数为 0 的课加入到队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int k : set) {
            if (outNum.get(k) == 0) {
                queue.offer(k);
            }
        }
        while (!queue.isEmpty()) {
            //队列拿出来的课代表要删除的节点
            //要删除的节点的 list 中所有课的先修课个数减一
            int v = queue.poll();
            ArrayList<Integer> list = inNodes.getOrDefault(v, new ArrayList<>());

            for (int k : list) {
                int num = outNum.get(k);
                //当前课的先修课要变成 0, 加入队列
                if (num == 1) {
                    queue.offer(k);
                }
                //当前课的先修课个数减一
                outNum.put(k, num - 1);
            }
        }

        //判断所有课的先修课的个数是否为 0
        for (int k : set) {
            if (outNum.get(k) != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean canFinishWithDFS(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> outNodes = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int rows = prerequisites.length;
        for (int i = 0; i < rows; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            set.add(key);
            if (!outNodes.containsKey(key)) {
                outNodes.put(key, new ArrayList<>());
            }
            //存储当前节点的所有先修课程
            ArrayList<Integer> list = outNodes.get(key);
            list.add(value);
        }

        HashSet<Integer> visitedFinish = new HashSet<>();
        //判断每一门课
        for (int k : set) {
            if (!dfs(k, outNodes, new HashSet<>(), visitedFinish)) {
                return false;
            }
            visitedFinish.add(k);
        }
        return true;
    }

    private boolean dfs(int start, HashMap<Integer, ArrayList<Integer>> outNodes, HashSet<Integer> visited,
                        HashSet<Integer> visitedFinish) {
        //已经处理过或者到了叶子节点
        if (visitedFinish.contains(start) || !outNodes.containsKey(start)) {
            return true;
        }
        //出现了环
        if (visited.contains(start)) {
            return false;
        }
        //将当前节点加入路径
        visited.add(start);
        ArrayList<Integer> list = outNodes.get(start);
        for (int k : list) {
            if(!dfs(k, outNodes, visited, visitedFinish)){
                return false;
            }
        }
        visited.remove(start);
        return true;
    }
}
