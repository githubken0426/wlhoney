package cn.honey.home.config;

import java.util.Map;

public class TestMain {
    enum Test {
        RED, YELLOW, GREEN;
    }

    private final static String str = "ab";

    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyHashMap<>();
        map.put(100, 100);
        for (int i = 1; i < 20; i++) {
            map.put(i, i);
        }
        System.out.println(map.get(19));

        System.out.println("***********************");
        test();
    }

    public static int getHash(Object o) {
        return o.hashCode();
    }

    public static void test() {
        String a = "a";
        String str_a = new String("a");
        System.out.println(a == str_a);
        System.out.println(a == str_a.intern());

        String b = "b";
        String s = a + b;
        System.out.println(s == str);

        System.out.println(s.intern() == str);

        System.out.println("abc" == str + "c");
    }
}
