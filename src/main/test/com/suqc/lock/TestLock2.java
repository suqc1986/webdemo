package com.suqc.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock2 {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    public static void main(String[] args){
        final TestLock2 test2 = new TestLock2();
        MyThread thread1 = new MyThread(test2);
        MyThread thread2 = new MyThread(test2);
        thread1.start();
        thread2.setPriority(10);
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
    public void insert(Thread thread) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName()+"得到了锁!");
            Thread.sleep(10*1000);
        } finally {
            System.out.println(thread.getName()+"执行finally!");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁!");
        }
    }
}
class MyThread extends Thread{
    private TestLock2 test2;
    public MyThread(TestLock2 test2){
        this.test2 = test2;
    }

    @Override
    public void run() {
        try {
            test2.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
