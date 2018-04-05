---
title: 时隔多年又开始弄Github Pages
description: 关于某天晚上又是深夜一两点在修改自己博客的故事
categories:
 - 博客教程
tags: [jekyll]
last_modified_at: 2017-11-21T10:46:49-04:00
---
# 关于这个主题 basically

发生了一些这样的故事

![image-center]({{ site.url }}{{ site.baseurl }}/assets/images/chrome_2017-11-21_01-40-43.png){: .align-center}

这个确实是意想不到的事情

总被github说这个主题不合适，但明明就是他自己商店里的主题

## 第二个地方是首页的图片

确实是一个个html找了好久，这个结构比较乱

当然也可能是我脑子转不动了

### 第三点

当我把 index.md 改好之后发生了一个这样的事情

```yml
paginate: true
alt_title: "Res0liya"
sub_title: "To be or not to be"
image: /assets/images/amine-ounnas-180287.jpg
```

**Posts**都丢了，真是奇怪

但**其实关键就在于这一行**

```yml
paginate: false
```

是否**翻页**，这个让我有些无奈...

还需要自己仔细看看

## 第四点---翻页

时隔这么久已经忘却了

总之翻页现在已经稳稳的了

## 第五点---图片的这个绿绿的滤镜啊

## 第六点---开启评论功能

## 第七点---完善所有的东西

## 最后

慢慢来吧，想要一个自己定制的好看的博客

其实也算是一项**大工程**了

除此之外...**早睡早睡啊...明天还有体侧的一千米呢**

## 加入next主题

https://luoboyala.github.io

安装了ruby，后来要安装msys2

还好next有中文安装文档

github主页：https://github.com/Simpleyyt/jekyll-theme-next

安装文档：http://theme-next.simpleyyt.com/getting-started.html

* 出现的几个问题

bundle install报错解决方案：

管理员下打开控制台powershell,执行安装脚本时报错

https://www.cnblogs.com/zhaozhan/archive/2012/06/01/2529384.html

还有问题 commonmaker

解决详见另外一篇tutorial