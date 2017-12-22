package com.jdk.test;

/**
 * @author ��Ƽ
 * @date 2017/12/18 0018
 * ��֤wait(3000)�������ú�3���ȥ�˲�������ִ�У�����cpu��Դ�⣬����Ҫ�ȴ�����Դ��
 */
public class WaitForever {

    public static Object monitor = new Object();
    static long start;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("����ִ��wait��3000������");
                synchronized (monitor) {
                    try {
                        start = System.currentTimeMillis();
                        monitor.wait(3000);
                        System.out.println("wait����������");
                        System.out.println("�ȴ���" + (System.currentTimeMillis() - start) / 1000 + "�롣");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(100);
//        ģ������Դ��ռ�á�
        synchronized (monitor) {
            Thread.sleep(500000);
        }
    }
}
