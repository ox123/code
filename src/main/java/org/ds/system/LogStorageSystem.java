package org.ds.system;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LogStorageSystem {
    private final HashMap<String, Integer> dmap = new HashMap<>();
    private final String[] gras = "Year:Month:Day:Hour:Minute".split(":");
    private final int[] ends = {4, 7, 10, 13, 16};

    public static void main(String[] args) {
        LogStorageSystem logStorageSystem = new LogStorageSystem();
        logStorageSystem.put(1, "2017:01:01:23:59:59");
        logStorageSystem.put(2, "2017:01:01:22:59:59");
        logStorageSystem.put(3, "2016:01:01:00:00:00");
        System.out.println(logStorageSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out.println(logStorageSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }

    public String getKeyByGra(String timestamp, String gra) {
        for (int i = 0; i < gras.length; i++) {
            if (gra.equals(gras[i])) {
                return timestamp.substring(0, ends[i]);
            }
        }
        return timestamp;
    }

    public void put(int id, String timestamp) {
        dmap.put(timestamp, id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        String sk = getKeyByGra(s, gra);
        String ek = getKeyByGra(e, gra);
        List<Integer> ans = new LinkedList<>();
        for (String key : dmap.keySet()) {
            String ck = getKeyByGra(key, gra);
            if (sk.compareTo(ck) <= 0 && ck.compareTo(ek) <= 0) {
                ans.add(dmap.get(key));
            }
        }
        return ans;
    }
}
