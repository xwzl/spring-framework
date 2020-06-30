package com.spring.test.aspect.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuweizhi
 * @since 2019/04/23 11:27
 */
public class ReflectSample {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Book.class;

        Book book = new Book("Faker 成神之战", "恩静", 12);
        book.printBook();

        Field author = clazz.getDeclaredField("author");
        // 打破访问权限
        author.setAccessible(true);
        // 改变 book 对象的属性值
        author.set(book, "Faker");
        book.printBook();

        // 反射在不改变源代码的情况下调用方法标，可做出适当增强
        ReflectSample reflectSample = new ReflectSample();
        Class<?> clazz1 = reflectSample.getClass();

        Method printBook = clazz1.getDeclaredMethod("printBook", String.class, String.class, int.class);
        printBook.setAccessible(true);

        // 反射调用方法，未做曾强
        invoke(reflectSample, printBook);

        // 参数填充
        Object[] objs = new Object[3];
        objs[0] = "深入 Java 虚拟机";
        objs[1] = "周志明";
        objs[2] = 650;

        // 反射增强方法
        invokeEnhance(reflectSample, printBook, objs);

    }

    private static void invoke(ReflectSample reflectSample, Method printBook) throws IllegalAccessException, InvocationTargetException {
        printBook.invoke(reflectSample, "Java 编程思想", "哈哈", 765);
    }

    private static void invokeEnhance(ReflectSample reflectSample, Method printBook, Object[] objs) throws IllegalAccessException, InvocationTargetException {
        System.out.println();
        System.out.println("----------------------方法增强前，逻辑自定义----------------------\n");
        printBook.invoke(reflectSample, objs);
        System.out.println();
        System.out.println("----------------------方法增强后，逻辑自定义----------------------");
    }

    public void printBook(String bookName, String author, int pages) {
        System.out.println(bookName + "的作者是" + author + "，一共有" + pages + "页\n");
    }


}

class Book {

    private String bookName;

    private String author;

    private int pages;

    public Book() {
    }

    public Book(String bookName, String author, int pages) {
        this.bookName = bookName;
        this.author = author;
        this.pages = pages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void printBook() {
        System.out.println(bookName + "的作者是" + author + "，一共有" + pages + "页\n");
    }

}

class LruCache<K, V> {

    private LinkedHashMap<K, V> lruCache = null;

    public void setLruCache(int maxCache) {
        System.out.println("Set 方法 外部");
        this.lruCache = new LinkedHashMap<K, V>(maxCache, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                System.out.println("Set 方法 内部");
                return super.removeEldestEntry(eldest);
            }
        };
    }

    public V put(K k, V v) {
        V put = lruCache.put(k, v);
        return put;
    }

    public static void main(String[] args) {
        LruCache<Integer, Integer> l = new LruCache<>();
        l.setLruCache(10);
        Integer put = l.put(1, 1);
        System.out.println(put);
        Integer put1 = l.put(2, 1);
        System.out.println(put);
        Integer put2 = l.put(3, 1);
        Integer put4 = l.put(1, 12);
        System.out.println(put4);

        LinkedHashMap a = new LinkedHashMap(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("Set 方法 内部");
                return super.removeEldestEntry(eldest);
            }
        };
    }
}
