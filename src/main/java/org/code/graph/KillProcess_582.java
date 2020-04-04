package org.code.graph;

import java.util.*;

/**
 * 典型深度遍历
 */
public class KillProcess_582 {
    List<Integer> res = new ArrayList(); // 返回结果

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        System.out.println(new KillProcess_582().killProcess(pid, ppid, 5));
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        int n = pid.size();
        if (ppid.size() != n) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; ++i) {
            int par = ppid.get(i);
            int id = pid.get(i);
//            if(!adjList.containsKey(par)) {
//                adjList.put(par, new HashSet<>());
//            }
            adjList.getOrDefault(par, new HashSet<>()).add(id);// 最新版本写法
        }

        // 使用队列模拟bfs
        List<Integer> killedList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        killedList.add(kill);
        while (!q.isEmpty()) {
            Integer f = q.poll();
            if (adjList.containsKey(f)) {
                HashSet<Integer> set = adjList.get(f);
                for (Integer id : set) {
                    q.add(id);
                    killedList.add(id);
                }
            }
        }
        return killedList;
    }

    /***
     * ------------------------------------------
     * 使用dfs方式
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess1(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // 树形结构
        // 建立树形结构，key为父节点，value为父节点下所有子节点集合
        for (int i = 0; i < ppid.size(); i++) {
            int p = ppid.get(i);
            int c = pid.get(i);
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(c);
            map.put(p, list);
        }
        // 将kill加入返回结果
        res.add(kill);
        // dfs查找kill下所有子节点
        dfs(map, kill);
        return res;
    }

    void dfs(Map<Integer, List<Integer>> map, int id) {
        if (!map.containsKey(id)) return;
        List<Integer> list = map.get(id);
        for (int pid : list) {
            res.add(pid);
            dfs(map, pid);
        }
    }
}
