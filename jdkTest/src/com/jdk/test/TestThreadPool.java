package com.jdk.test;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ��Ƽ on 2017/10/26 0026.
 */
public class TestThreadPool {

    //��ʵ����Է���ִ��shutdown�����̳߳ػ����������е��̼߳������С�
    //shutdownNow�������ж������̣߳������߳��Լ��������е��̣߳�
    //������������������ʹ��interrupt�ж��߳�,��ζ�����û����Ӧ�ж��߼����̻߳�һֱ������ȥ
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new Task());
        Thread.sleep(2500);
        executor.shutdown();
        Thread.sleep(2500);
        executor.shutdownNow();
        System.out.println(executor.isTerminated());
        System.out.println(executor.isTerminating());
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //��Ӧ�жϵ��߼�
                if (Thread.interrupted()) {
                    break;
                }
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("sleep���ж���");
                    //��Ӧ�жϵ��߼�
//                    break;
                }
            }
            System.out.println("�߳���Ӧ�жϺ��˳�");
        }
    }

    @Test
    public void testState() {
        int COUNT_BITS = 29;
        int CAPACITY = (1 << 29) - 1;
        System.out.println(Integer.toBinaryString(CAPACITY).length());
        System.out.println(Integer.toBinaryString(~CAPACITY));

        final int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;
        System.out.println("-1�Ķ�����"+Integer.toBinaryString(-1));
        System.out.println("running: " + Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN: " + Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP: " + Integer.toBinaryString(STOP));
        System.out.println("TIDYING: " + Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED: " + Integer.toBinaryString(TERMINATED));

        System.out.println("running is less than shutdown : " + (RUNNING < SHUTDOWN));
        System.out.println("STOP is less than shutdown : " + (STOP < SHUTDOWN));
        System.out.println("TIDYING is less than shutdown : " + (TIDYING < SHUTDOWN));
        System.out.println("TERMINATED is less than shutdown : " + (TERMINATED < SHUTDOWN));
    }
}

