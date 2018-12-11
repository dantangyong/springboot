package com.example.demo.test;

/**
 * @ClassName: TestString
 * @description: String
 * @author: dty
 * @create: 2018-12-10 16:24
 */
public class TestString {


    public static void main(String[] args) {
        String s = " swd123  ";
        s.trim();
        System.out.println(
                s
        );
        System.out.println(trim(s));
        System.out.println(indexOf(s,'d'));
        System.out.println(s.indexOf("d"));
        System.out.println("Boolean.valueOf(isPrint) :" +Boolean.valueOf(" "));
    }


    public static String trim(String s) {
        int len = s.length();
        int len2 = s.length();
        int st = 0;

        char[] val = s.toCharArray();
        while (st < len && val[st] < ' ') {
            st++;
        }
        while (st < len && val[len - 1] < ' ') {
            len--;
        }
        return ((st > 0) || (len < len2)) ? s.substring(st, len) : s;
    }

    public static int indexOf(String s,char c){
        char [] val = s.toCharArray();
        for (int i = 0; i < val.length; i++) {
            if(val[i] ==c){
                return  i;
            }
        }
       return -1;
    }
}
