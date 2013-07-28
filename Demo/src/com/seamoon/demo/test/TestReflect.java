/**
 * 
 */
package com.seamoon.demo.test;

import java.lang.reflect.Field;

/**
 * @author Administrator
 * @Date   2013-5-3下午09:33:15
 * @File   TestReflect.java
 */
public   class   TestReflect   { 
    public   static   void   main(String[]   args){ 
               APerson   a=new   APerson(); 
               Field   fields[]   =   a.getClass().getDeclaredFields(); 
               String[]   name   =   new   String[fields.length]; 
               Object[]   value   =   new   Object[fields.length]; 
                     
               try{ 
                         Field.setAccessible(fields,   true); 
                         for   (int   i   =   0;   i   <   name.length;   i++)   { 
                                name[i]   =   fields[i].getName(); 
                                System.out.println(name[i]   +   "-> "); 
                                value[i]   =   fields[i].get(a); 
                                System.out.println(value[i]); 
                         } 
               } 
               catch(Exception   e){ 
                        e.printStackTrace(); 
               } 
   } 
} 
