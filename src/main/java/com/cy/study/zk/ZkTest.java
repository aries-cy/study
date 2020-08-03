package com.cy.study.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

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
public class ZkTest  {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
                "127.0.0.1",
                5000,
                4000,
                new ExponentialBackoffRetry(4000, 3)
        );
        //建立连接
        curatorFramework.start();

        //创建节点目录
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/LOCKS");

        for(int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"尝试获取锁");
                try {
                    //加锁
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName()+"获取锁成功");
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        lock.release();
                        System.out.println("释放锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
