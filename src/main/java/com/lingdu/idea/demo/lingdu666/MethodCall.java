package com.lingdu.idea.demo.lingdu666;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;


/**
 * @author lingdu
 */
public class MethodCall {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodCall.class);
    private static String userName;
    private static int age;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        LOGGER.info("test");

        // TODO: lingdu 2020-03-08  这个地方有点卡 需要考虑优化啊下
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    public static void main(String[] args) {
        test1();
    }
*/

    public static void test1() {
        test2();
        System.out.println("abcde");
    }


    public static void test3(String userName,int age,String addr) {
        MethodCall.userName = userName;
        MethodCall.age = age;

        LOGGER.info("test");

        MethodCall methodCall = new MethodCall();

        for (int i = 0; i < 100; i++) {
            System.out.println("test");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1000);

        System.out.println("userName = " + userName + ", age = " + age + ", addr = " + addr);
        System.out.println("userName = " + userName + ", age = " + age + ", addr = " + addr);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("userName = " + userName + ", age = " + age + ", addr = " + addr);
        LOGGER.info("userName = [" + userName + "], age = [" + age + "], addr = [" + addr + "]");
        LOGGER.info("userName = [" + userName + "], age = [" + age + "]");
        //groovyScript("'\"' + _1.collect { it + ' = [\" + ' + it + ' + \"]'}.join(', ') + '\"'", methodParameters())
        System.out.println("test3");
    }


    // TODO: lingdu 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    // TODO: lingau 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    // TODO: lingbu 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    // TODO: lingcu 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    // TODO: lingfu 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    // TODO: lingeu 2020-03-08 17:35:45 这个有点问题，回头我需要优化下这块代码
    public static void test2() {
        System.out.println("test2");
    }
}
