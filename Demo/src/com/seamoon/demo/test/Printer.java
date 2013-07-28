/**
 * 
 */
package com.seamoon.demo.test;

/**
 * @author Administrator
 * @Date   2013-5-3下午10:45:38
 * @File   Printer.java
 */
public class Printer implements Runnable {  
    private String name;  
    private Object self;  
    private Object next;  
  
    private Printer(String name, Object self, Object next) {  
        this.name = name;  
        this.self = self;  
        this.next = next;  
    }  
  
    public void run() {  
        int count = 3;  
        while (count > 0) {  
//            System.out.println(count);  
            synchronized (self) {  
                synchronized (next) {  
                    System.out.println(name);  
                    count--;  
                    next.notify();  
                }  
                try {  
                    self.wait();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        Object a = new Object();  
        Object b = new Object();  
        Object c = new Object();  
  
        Printer pa = new Printer("A", a, b);  
        Printer pb = new Printer("B", b, c);  
        Printer pc = new Printer("C", c, a);  
  
        new Thread(pa).start();  
        Thread.sleep(10);  
        new Thread(pb).start();  
        Thread.sleep(10);  
        new Thread(pc).start();  
        Thread.sleep(10);  
    }  
}  
