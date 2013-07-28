/**
 * 
 */
package com.seamoon.demo.test;

/**
 * @author Administrator
 * @Date   2013-5-3下午09:33:41
 * @File   APerson.java
 */
class   APerson{ 
    private  String   name; 
    private  String   sex; 
    private   int   age; 

    APerson(){ 
           name= "John "; 
           sex= "男 "; 
           age=45; 
    } 

    public   int   getAge()   { 
                    return   age; 
    } 
    public   void   setAge(int   age)   { 
                    this.age   =   age; 
    } 
    public   String   getName()   { 
                    return   name; 
    } 
    public   void   setName(String   name)   { 
                    this.name   =   name; 
    } 
    public   String   getSex()   { 
                    return   sex; 
    } 
    public   void   setSex(String   sex)   { 
                    this.sex   =   sex; 
    } 
}
