---
title: Java学习-Java核心技术卷1-第四章
description: Java的类
categories:
  - Java学习
tags:
  - Java程序设计
---
# Chapter4 面向对象

# 需要了解的类库

---

- **java.util.GregorianCalendar**
- **java.text.DateFormatSymbols**
- **java.util.Random**

# 类

---

- **类, 构造, 实例, 封装, 实例域, 方法等概念**
- **对象: 对象的行为, 状态, 标识三个特性**
- **类之间的关系: 依赖(uses-a), 聚合(has-a), 继承(is-a)**
- **UML语言来表达类之间的一些关系**
- **一个对象变量并没有实际包含一个对象,而是仅仅引用一个对象. 任何对象变量的值都是对存储在另一个地方的一个对象的引用, new操作符的返回值也是一个引用.**
- **隐式参数和显式参数, 隐式参数指对象的实例, 在方法中可以用this代指, 显式参数则为方法括号中的参数**
- **封装的优点: 保护私密数据, 更改器方法可以执行错误检查.**
- **封装的要求: 一个私有的数据域, 一个公有的域访问器方法, 一个公有的域更改器方法.**
- **私有域private以及final的用法**
- **静态域与静态方法, 静态常量和静态方法可以不用实例化对象就调用. 用静态方法的情况: 1.不需要访问对象状态,其所需参数都是通过显式参数提供 2.只需要访问类的静态域**
- **工厂方法**
- **对象引用进行的是值的传递**
- **重载: 相同方法名, 不同参数**
- **初始化块以及静态的初始化块**
- **对象析构和finalize方法, 由于Java自动垃圾回收的机制而不支持析构器, 同时因为难以知道finalize方法什么时候调用而不用(不安全), 一般需要关闭的是一些资源如文件流等对象的close方法**
- **静态导入, 如 import static java.lang.System.*; 就可以直接 out.println了(似乎也不常见)**
- **类设计技巧**
  - **一定要保证数据私有**
  - **一定要对数据初始化**
  - **不要在类中使用过多的基本类型**
  - **不是所有的域都需要独立的域访问器和域更改器**
  - **将职责过多的类进行分解**
  - **类名和方法名要能够体现他们的职责**

# 一些代码注意点

---

**所有与通配符匹配的源文件都将被编译成为类文件**

```java
    javac Employee*.java
```

**注意不要编写返回可变对象的访问器方法. 下代码中test代码中d和harry.hireDay引用同一个对象, 更改d就会自动改变这个雇员对象的私有状态**

```java
    class Employee{
    	private Date hireDay;
    	public Date getHireDay()
       {
          return hireDay;
       }
    }
    //test代码中
    Employee harry=...;
    Date d=harry.getHireDay();
    d.setTime(...);
    //正确代码
    public Date getHireDay()
       {
          return hireDay.clone();
       }
```

**总结Java方法参数的使用情况:**

1. **不能修改一个基本数据类型的参数**
1. **可以改变一个对象参数的状态**
1. **不能让对象参数引用一个新的对象**

```java
    /**
     * This program demonstrates parameter passing in Java.
     * @version 1.00 2000-01-27
     * @author Cay Horstmann
     */
    public class ParamTest
    {
       public static void main(String[] args)
       {
          /*
           * Test 1: Methods can't modify numeric parameters
           */
          System.out.println("Testing tripleValue:");
          double percent = 10;
          System.out.println("Before: percent=" + percent);
          tripleValue(percent);
          System.out.println("After: percent=" + percent);
    
          /*
           * Test 2: Methods can change the state of object parameters
           */
          System.out.println("\nTesting tripleSalary:");
          Employee harry = new Employee("Harry", 50000);
          System.out.println("Before: salary=" + harry.getSalary());
          tripleSalary(harry);
          System.out.println("After: salary=" + harry.getSalary());
    
          /*
           * Test 3: Methods can't attach new objects to object parameters
           */
          System.out.println("\nTesting swap:");
          Employee a = new Employee("Alice", 70000);
          Employee b = new Employee("Bob", 60000);
          System.out.println("Before: a=" + a.getName());
          System.out.println("Before: b=" + b.getName());
          swap(a, b);
          System.out.println("After: a=" + a.getName());
          System.out.println("After: b=" + b.getName());
       }
    
       public static void tripleValue(double x) // doesn't work
       {
          x = 3 * x;
          System.out.println("End of method: x=" + x);
       }
    
       public static void tripleSalary(Employee x) // works
       {
          x.raiseSalary(200);
          System.out.println("End of method: salary=" + x.getSalary());
       }
    
       public static void swap(Employee x, Employee y)
       {
          Employee temp = x;
          x = y;
          y = temp;
          System.out.println("End of method: x=" + x.getName());
          System.out.println("End of method: y=" + y.getName());
       }
    }
    
    class Employee // simplified Employee class
    {
       private String name;
       private double salary;
    
       public Employee(String n, double s)
       {
          name = n;
          salary = s;
       }
    
       public String getName()
       {
          return name;
       }
    
       public double getSalary()
       {
          return salary;
       }
    
       public void raiseSalary(double byPercent)
       {
          double raise = salary * byPercent / 100;
          salary += raise;
       }
    }
```