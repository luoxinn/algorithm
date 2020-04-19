package com.gloria.study.algorithm.lock.deadlock;

/**
 * @author luoxin
 * @version 1.0
 * @date 2020/4/19 4:45 下午
 */
public class DeadLock {


    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
               DeadLock.method1();
            }
        });
        a.setName("a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLock.method2();
            }
        });
        b.setName("b");
        a.start();
        b.start();

    }

    public static void method1(){

        synchronized (String.class){
//            try {
////                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "正在尝试获取Integer");
            synchronized (Integer.class){

            }
            System.out.println(Thread.currentThread().getName() + "已经获取Integer");
        }

    }


    public static void  method2(){
        synchronized (Integer.class){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "正在尝试获取String");
            synchronized (String.class){

            }
            System.out.println(Thread.currentThread().getName() + "已经获取String");
        }
    }

}
