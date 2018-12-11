package com.example.demo.test;

import com.example.demo.entity.Book;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestLang
 * @description: 测试 apache lang 方法
 * @author: dty
 * @create: 2018-12-05 17:04
 */
public class TestLangClassUtils {

    public static void main(String[] args) {
        // convertClassesToClassNames();
        //convertClassNamesToClasses();
//        getClass01();
        getShortClassName();
    }

    public static void convertClassesToClassNames() {
        List<Class<?>> listUser = new ArrayList<>();
        listUser.add(String.class);
        listUser.add(Integer.class);
        listUser.add("dwdw".getClass());
        List<String> listString = ClassUtils.convertClassesToClassNames(listUser);
        for (String s :
                listString) {
            System.out.println(s);
        }

    }

    public static void convertClassNamesToClasses() {

        List<String> listString = new ArrayList<>();
        listString.add("com.example.demo.entity.Book");

        List<Class<?>> classList = ClassUtils.convertClassNamesToClasses(listString);
        for (Class z :
                classList) {
            try {
                Constructor<?> constructor = z.getConstructor(String.class);
                   Object o = constructor.newInstance("hha");
                Book book = (Book) o;
                System.out.println(book.getTitle());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(z);
        }

    }

    public static void getClass01(){
        try {
            Class<?> clazz = ClassUtils.getClass("com.example.demo.entity.Book");
            System.out.println(clazz.getSimpleName());
            String packageName = ClassUtils.getPackageName(clazz);
            System.out.println(packageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getShortClassName(){
        String shortName = ClassUtils.getShortClassName("com.example.demo.entity.Book");
        System.out.println(shortName);
        int [] c = {1,2,4};
        System.out.println(c.length);
        int len = Array.getLength(c);
        int len2 = ArrayUtils.getLength(c);
        System.out.println(len2+"\r"+len);
        String c1 = " dwdwd ";
        System.out.println(c1.trim());
    }

}
