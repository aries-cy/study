package com.cy.study.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 测试
 *  1.先去获取锁，创建自己的临时顺序节点
 *  2.判断能不能加锁：我的节点是不是第一个节点，如果是，则加锁成功
 *  3.另一个客户端去创建临时顺序节点
 *  4.判断能否加锁成功
 *  5.监听上一个节点的变化
 *  6.客户端A释放锁，删除顺序节点
 *  7.zk通知客户端B，节点已删除
 *  8.再次尝试加锁
 *  9.加锁成功
 * @author cy
 */
public class ZkTest  implements Runnable, Lock {

    static int inventory = 10;
    private static final int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(1);

    private static final String IP_PORT = "127.0.0.1:2181";
    private static final String Z_NODE = "/LOCK";

    private static ZkClient zkClient = new ZkClient(IP_PORT);


    public static void main(String[] args) {
        try {

            for (int i = 1; i <= NUM; i++) {
                new Thread(new ZkTest()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            new ZkTest().lock();
            if (inventory > 0) {
                inventory--;
            }
            System.out.println(inventory);
            return;
        } finally {
            new ZkTest().unlock();
            System.out.println("释放锁");
        }
    }

    @Override
    public void lock() {
        // 尝试加锁
        if(tryLock()){
            return;
        }
        // 进入等待 监听
        waitForLock();
        // 再次尝试
        lock();
    }

    @Override
    public boolean tryLock() {
        try {
            zkClient.createPersistent(Z_NODE);
            return true;
        }catch (ZkNodeExistsException e){
            return false;
        }
    }

    @Override
    public void unlock() {
        zkClient.delete(Z_NODE);
    }

    public void waitForLock(){
        System.out.println("加锁失败");
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("唤醒");
                cdl.countDown();
            }
        };
        // 监听
        zkClient.subscribeDataChanges(Z_NODE, listener);
        if (zkClient.exists(Z_NODE)) {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(Z_NODE, listener);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
