package com.bobo.Lambda;

/**
 * @author wuxiaobo@didachuxing.com
 */
public class LambdaTest {

    @FunctionalInterface
    interface MyInterface{
        void hello(int x,int y);
    }

    private static void test(MyInterface myInterface) {
        myInterface.hello(1,2);
    }

    public static void main(String[] args) {
//        test((x,y) -> {
//            System.out.println(x+y);
//        });

        MyInterface myInterface = (x,y) -> {
          System.out.println(x+y);
        };
        myInterface.hello(1,2);
//
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        Collections.sort(list,(x,y)-> {
//            return x.compareTo(y);
//        });
//        System.out.println(list.toString());
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//
//        new Thread(()->{
//
//        });
    }
}
