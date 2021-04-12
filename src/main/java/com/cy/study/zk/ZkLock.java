//package com.cy.study.zk;
//
//import org.apache.zookeeper.ZooKeeper;
//
//import java.util.concurrent.locks.Lock;
//
///**
// * zookeeper实现分布式锁
// *
// * @author cy
// */
//public class ZkLock {
//
//    static int inventory = 1;
//    private static final int NUM = 5;
//
//    private static Zk zk = new Zk();
//
//    public static void main(String[] args) {
//        try {
//            for (int i = 0; i < NUM; i++) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            zk.lock();
//                            Thread.sleep(1000);
//                            if (inventory > 0) {
//                                inventory--;
//                            }
//                            System.out.println("库存为："+inventory);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } finally {
//                            zk.unlock();
//                        }
//                    }
//                }).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
