---
title: 使用elementUI的脱坑指南
description: 最近碰到的element UI的一些问题以及解决方案。
categories:
  - 技术
tags:
  - Vue
---

1. 深度选择器，当在`style scoped`中修改对应组件的样式时，发现预览之后样式并没有改变，可以确认样式的修改写入了文件中，但是因为覆盖的优先级的原因，并没有产生变化，这个时候有两种办法，一种是在`style scoped`之外，再加入`style`的域进行全局的样式修改；另一种则是在`style scoped`中，进行这样的声明