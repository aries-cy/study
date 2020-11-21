package com.cy.study.lock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印奇数偶数
 *
 * @author cy
 */
public class TwoThread {

    private volatile boolean flag = true;
    private static int total = 100;

    private volatile AtomicInteger num = new AtomicInteger(1);

    @Test
    public void method1(){
        Thread jsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num.get()<=total-1){
                    if(flag){
                        System.out.println(Thread.currentThread().getName()+" : "+num.getAndIncrement());
                        flag = false;
                    }
                }
            }
        });

        jsThread.setName("奇数线程");

        Thread osThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num.get()<=total){
                    if(!flag){
                        System.out.println(Thread.currentThread().getName()+" : "+num.getAndIncrement());
                        flag = true;
                    }
                }
            }
        });

        osThread.setName("偶数线程");

        jsThread.start();
        osThread.start();

    }

    @Test
    public void method2(){
        Object monitor = new Object();
        new Thread(new Os(monitor),"偶数").start();
        new Thread(new Js(monitor),"奇数").start();

    }

    static class Js implements Runnable{

        private Object monitor;
        //奇数线程从1开始打印
        private int value = 1;

        public Js(Object monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            while (value<100){
                synchronized (monitor){
                    System.out.println(Thread.currentThread().getName()+" : "+value);
                    value += 2;
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Os implements Runnable{

        private Object monitor;
        //奇数线程从1开始打印
        private int value = 0;

        public Os(Object monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            while (value<100){
                synchronized (monitor){
                    System.out.println(Thread.currentThread().getName()+" : "+value);
                    value += 2;
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
