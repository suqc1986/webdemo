package com.suqc.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock1 {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();//注意这个地方
    public static void main(String[] args){
        final TestLock1 test = new TestLock1();
        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
    }
    public void insert(Thread thread){
        if(lock.tryLock()){//尝试获取锁,获取不到返回false   获取到返回true  不等待
            try {
                System.out.println(thread.getName()+"得到了锁!");
                for(int i=0;i<5;i++){
                    arrayList.add(i);
                }
            } finally {
                System.out.println(thread.getName()+"释放了锁!");
                lock.unlock();
            }
        }else{
            System.out.println(thread.getName()+"获取锁失败!");
        }
    }
    /*
    public void insert(Thread thread){
        lock.lock();//获取锁,获取不到一直等待
        try {
            System.out.println(thread.getName()+"得到了锁!");
            for(int i=0;i<5;i++){
                arrayList.add(i);
            }
        } finally {
            System.out.println(thread.getName()+"释放了锁!");
            lock.unlock();
        }
    }*/
}
