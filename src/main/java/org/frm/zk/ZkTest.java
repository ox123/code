package org.frm.zk;

import org.apache.zookeeper.*;

import java.util.List;

public class ZkTest {
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("80.158.32.174:2181", 300, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(String.format("--->{}", watchedEvent.toString()));
                }
            });
            // 获取节点下面key列表
            List<String> children = zooKeeper.getChildren("/", true);
            children.forEach(key -> {
                System.out.println(key);
            });
            // 获取key值
            byte[] data = zooKeeper.getData("/path01", true, null);
            System.out.println(new String(data));
            // 判断key是否存在
            System.out.println(zooKeeper.exists("/path01", false));
            // 创建节点
            zooKeeper.create("/path01",
                    "data".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
//            System.out.println(zooKeeper.getch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
