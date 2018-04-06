---
title: Java学习-Java核心技术卷1-第三章
description: Java的基本操作
categories:
  - Java学习
tags:
  - Java程序设计
---
# Java核心技术卷1 chapter3 Java基本程序设计结构

## Java类

* java.lang.string
* java.lang.StringBuilder
* java.util.Scanner
* java.lang.System
* java.io.Console
* java.io.PrintWriter
* java.nio.file.Paths
* java,math.BigInteger
* java.util.Arrays

## 数据类型

* 整形

| 数据类型 | 存储需求 | 取值范围 |
| :------: | :------: | :------: |
| int | 4字节 | -2147483648~2147483647(正好超过20亿) |
| short | 2字节 | -32768~32767 |
| long | 8字节 | ...算了 |
| byte | 1字节 | -128~127 |

* Java没有unsigned类型
* 浮点型

| 数据类型 | 存储需求 | 取值范围 |
| :------: | :------: | :------: |
| float | 4字节 | 有效位数6-7位 |
| double | 8字节 | 有效位数15位 |

* 注意3.14F为float类型, 3.14/3.14D为double类型
* NaN: 0/0或者负数的平方根结果 Double.NaN(x)
* char类型: 用UTF-16编码描述一个代码单元
* Boolean类型

## 变量

* 变量初始化
* 常量用**final**, const为Java保留的关键字

## 运算符

* 三元运算符 condition ? yes : no
* 位运算符
    * &与,\|或,^异或,~非: 没有逻辑短路(&&和\||)
    * \>>和<<: 将二进制进行右移和左移操作
    * \>>>: 将0填充到高位, 没有<<<
* 数学函数Math类
* 数值类型转换
    * 直接进行合法转换: 有信息丢失的为int->float,long->float和long->double,编译器也有警告
    * 强制类型转换: 会有截断 int nx=(int) x
    * 还可以用各种类型类的函数
* 运算符优先级和结合性
* 枚举类型

```java
enum Size{S,M,L,XL};
Size s = Size.M;
```

* 字符串
    * Java的'+'加号了解一下
    * equal函数用于检测字符串是否相等
    * 空串和null不同
        ```java
        s.strength()=0;
        s.equal("");
        if(str!=null&&str.length()!=0)
        ```
    * 输入输出
        ```java
        Scanner in = new Scanner(System.in);

        System.out.println("what is your name?");
        String name = in.nextLine();

        System.out.println("how old are your?");
        int age=in.nextInt();
        ```
    * 格式化输出 printf
        ```java
        System.out.prinf();
        ```
    * 文件输入与输出
        ```java
        try {
            Scanner in = new Scanner(Paths.get("F:\\Github\\CourseRecord\\Java\\code\\src\\aaa.txt"));//读取文件
            while (in.hasNext()){
                System.out.println(in.nextLine());
            }
            PrintWriter out = new PrintWriter("F:\\Github\\CourseRecord\\Java\\code\\src\\aaa.txt");//写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        ```

## 控制流程

* 块作用域
* 条件语句 if else
* 循环 while/do while
* 确定循环 for
* 多重选择 switch case
* 中断控制流程语句 break和continue
* 大数值

## 数组

* 创建数组,都初始化为0;创建默认Boolean数组,都初始化为false;创建对象数组,都默认为null(比如String).
* for each循环以及数组拷贝(一般用于扩大数组长度)

```java
int[] a =new int[10];
for (int element:a){
        element=1;
    }
    System.out.println(Arrays.toString(a));
    for (int i=0;i<10;i++){
        a[i]=1;
    }
    System.out.println(Arrays.toString(a));
    int[] b = new int[5];
    b=Arrays.copyOf(a,8);
    System.out.println(Arrays.toString(b));
```

* 数组排序 Arrays类中的sort和binarySearch
* 二维数组
* 不规则数组
