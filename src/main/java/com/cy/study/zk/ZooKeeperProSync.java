package com.cy.study.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * zookeeper 分布式配置中心demo
 *
 * @author cy
 */
public class ZooKeeperProSync implements Watcher {

    /**
     * CountDownLatch允许一个或者多个线程等待其他线程完成操作
     */
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        //zookeeper配置数据存放路径
        String path = "/cy";
        //连接zookeeper，并注册一个一个默认的监听器
        zk = new ZooKeeper("127.0.0.1:2181",5000,new ZooKeeperProSync());
        //等待zk连接成功的通知
        connectedSemaphore.await();
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent event) {
        //zk连接成功通知事件
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                //每调用一次，N减1
                connectedSemaphore.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged) {
                //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
