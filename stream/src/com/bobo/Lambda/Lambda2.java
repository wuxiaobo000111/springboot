package com.bobo.Lambda;

import com.bobo.Lambda.entity.User;

import java.util.*;
import java.util.function.*;

/**
 * @author bobo
 */
public class Lambda2 {
    public static void main(String[] args) {
        isDoubleBinaryOperator();
    }

    /**
     * DoubleBinaryOperator double applyAsDouble(double left, double right)
     */
    public static void isDoubleBinaryOperator(){
        DoubleBinaryOperator doubleBinaryOperatorA = (double a, double b) ->  a+b;
        DoubleBinaryOperator doubleBinaryOperatorB = (double a,double b) ->  a-b;
        System.out.println(doubleBinaryOperatorA.applyAsDouble(StrictMath.random()*100,StrictMath.random()*100));
        System.out.println(doubleBinaryOperatorB.applyAsDouble(StrictMath.random()*100,StrictMath.random()*100));
        /**
         * 像类似地DoubleBinaryOperator这样的函数式接口还有很多它们都是被FunctionalInterface注解的函数式接口
         * 被FunctionalInterface注解过的interface必须符合FunctionalInterface规范
         * IntBinaryOperator,LongBinaryOperator等都和BinaryOperator相似
         */
       BinaryOperator<String> binaryOperator = (String s1,String s2) -> {
         return s1+s2;
       };
        String apply = binaryOperator.apply("123", "456");
        System.out.println(apply);
    }

    /**
     * BinaryOperator<T>——接收两个T对象，返回T对象
     */
    public static void isBinaryOperator(){
        BinaryOperator<StringBuilder> binaryOperator = (StringBuilder builder1, StringBuilder builder2) -> {
            builder1.append(builder2);return builder1;
        };
    }

    /**
     * UnaryOperator<T>——接收T对象，返回T对象
     */
    public static void isUnaryOperator(){
        UnaryOperator<User> unaryOperator = (User user) -> {user.setId(4);user.setUserName("alice");return user;};
        User user = unaryOperator.apply(new User());
        System.out.println(user);
    }

    /**
     * Supplier<T>——提供T对象（例如工厂），不接收值
     */
    public static void isSupplier(){
        Supplier<List<User>> supplier = () -> Collections.synchronizedList(new ArrayList<User>());
        List<User> userList = supplier.get();
        userList.add(new User("Blake",5));userList.add(new User("Alice",4));
        System.out.println(userList);
    }

    /**
     * Function<T, R>——接收T对象，返回R对象
     */
    public static void isFunction(){
        String s ="Many other students choose to attend the class, although they will not get any credit. ";
        Function<String,String[]> stringFunction = (String str) -> {return str.split("[^\\w]");};
        String[] strings = stringFunction.apply(s);
        for (String s1:strings)
        {
            System.out.println(s1);
        }

        Function stream = (S) -> {return new Object();};
        //奇怪的语法
        Object o = stream.apply("hello");
        System.out.println(o.getClass());
    }

    /**
     * Consumer<T>——接收T对象，不返回值
     */
    public static void isConsumer(){
        Consumer<List> listConsumer = (List list) -> {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        };

        List<String> list = new ArrayList<>(Arrays.asList("Alice","BOb"));
        listConsumer.accept(list);
    }

    /**
     * Predicate<T>——接收T对象并返回boolean
     */
    public static void isPredicate(){
        Predicate<String> predicate = (String s) -> { return s!=null;};
        System.out.println("判断是否为Null:"+predicate.test(null));

        Predicate<Integer> integerPredicate = (Integer a) -> {return (a>10);};
        System.out.println(integerPredicate.test(8));

        Predicate<String[]> predicateStrings = (String...strs) -> {return strs.length >= 3;};
        System.out.println(predicateStrings.test(new String[]{"","",""}));
    }
}