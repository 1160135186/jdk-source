package com.jdk.test;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author ��Ƽ
 * @date 2017/12/9 0009
 */
public class TestHashTable {

    public static void main(String[] args) {
        testHashtableAPIs();
    }

    private static void testHashtableAPIs() {
        // ��ʼ���������
        Random r = new Random();
        // �½�Hashtable
        Hashtable table = new Hashtable();
        // ��Ӳ���
        table.put("one", r.nextInt(10));
        table.put("two", r.nextInt(10));
        table.put("three", r.nextInt(10));

        // ��ӡ��table
        System.out.println("table:" + table);

        // ͨ��Iterator����key-value
        Iterator iter = table.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println("next : " + entry.getKey() + " - " + entry.getValue());
        }

        // Hashtable�ļ�ֵ�Ը���
        System.out.println("size:" + table.size());

        // containsKey(Object key) :�Ƿ������key
        System.out.println("contains key two : " + table.containsKey("two"));
        System.out.println("contains key five : " + table.containsKey("five"));

        // containsValue(Object value) :�Ƿ����ֵvalue
        System.out.println("contains value 0 : " + table.containsValue(new Integer(0)));

        // remove(Object key) �� ɾ����key��Ӧ�ļ�ֵ��
        table.remove("three");

        System.out.println("table:" + table);

        // clear() �� ���Hashtable
        table.clear();

        // isEmpty() : Hashtable�Ƿ�Ϊ��
        System.out.println((table.isEmpty() ? "table is empty" : "table is not empty"));
    }

}
