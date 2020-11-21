package com.cy.study.lock;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * 自定义同步器
 *
 * @author cy
 */
public class Sync extends AbstractQueuedLongSynchronizer {


    @Override
    protected boolean isHeldExclusively() {
        return getState()==1;
    }

    @Override
    protected boolean tryAcquire(long arg) {
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(long arg) {
        if(getState()==0){
            throw new IllegalMonitorStateException();
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
}
