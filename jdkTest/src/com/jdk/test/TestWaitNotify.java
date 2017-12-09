package com.jdk.test;

/**
 * @author ��Ƽ
 * @date 2017/12/9 0009
 */
//java.lang.IllegalMonitorStateException�쳣�����Եȴ�һ������ļ���������ȥ֪ͨ�������ڵȴ����������������̣߳�����û��ӵ�����������������Ȩ��
public class TestWaitNotify {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        object.wait();
                        System.out.println("waitThread�̱߳�������");
                    } catch (InterruptedException e) {
                        //catchִ�в�׽�쳣��Ĵ���

//                        System.out.println("waitThread�̱߳��ж���");
                        e.printStackTrace();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        System.out.println("��ӡ�쳣");
                    }
                }
            }
        });
        waitThread.start();

        System.out.println("waitThread�߳��Ѿ�����wait״̬��");
        Thread.sleep(1000);
        //����
//        synchronized (object) {
//            object.notify();
//        }
        //�ж�
        waitThread.interrupt();
        Thread.sleep(1000);

    }
}
