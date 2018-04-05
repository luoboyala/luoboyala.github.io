---
title: Next Theme Individual Build Tutorial
description: 个人搭建NexT博客的一点小问题和解决方案
categories:
 - 博客教程
tags: [jekyll]
---
# 记录博客搭建的过程

初步步骤参照[指南](http://theme-next.simpleyyt.com/getting-started.html)

此次搭建建立于上次搭建安装失败的基础上

## 安装ruby包

安装包应该都可以下载到,我这里用的是rubyinstaller-2.5.0-2-x64版本

完成后会询问你是否安装msys2和mingw开发工具包等,我这里默认安装

具体也不太清楚这两者的具体用途,但是之前搭建失败貌似就是这方面的原因,因此考虑全部安装

## 安装bundler

因为考虑到安装包bundler的位置问题,我打算放在F:\GitHub下,安装好包,然后再考虑clone这个next主题

关于cmd(我用的Cmder)无法进入其他盘的办法,直接输入盘符F:就好了

## 下载next主题

## 安装依赖

报错如下:

```sh
$ bundle install
  Bundler could not find compatible versions for gem "mini_portile2":
  In snapshot (Gemfile.lock):
    mini_portile2 (= 2.2.0)

  In Gemfile:
    github-pages was resolved to 155, which depends on
      jekyll-mentions (= 1.2.0) was resolved to 1.2.0, which depends on
        html-pipeline (~> 2.3) was resolved to 2.7.0, which depends on
          nokogiri (>= 1.4) was resolved to 1.8.1, which depends on
            mini_portile2 (~> 2.3.0) x64-mingw32

    github-pages was resolved to 155, which depends on
      jekyll-mentions (= 1.2.0) was resolved to 1.2.0, which depends on
        html-pipeline (~> 2.3) was resolved to 2.7.0, which depends on
          nokogiri (>= 1.4) was resolved to 1.8.1, which depends on
            mini_portile2 (~> 2.2.0)

Running `bundle update` will rebuild your snapshot from scratch, using only
the gems in your Gemfile, which may resolve the conflict.
```

根据提示输入bundle update,装了一大堆莫名其妙的东西

好的然后bundle install,成功了

啧,果然之前总报错就是我没有完整安装msys2的原因吗

## 简单部署

报错如下:

```sh
$ bundle exec jekyll server
  Configuration file: F:/Github/jekyll-theme-next/_config.yml
            Source: F:/Github/jekyll-theme-next
       Destination: F:/Github/jekyll-theme-next/_site
  Incremental build: disabled. Enable with --incremental
      Generating...
   GitHub Metadata: No GitHub API authentication could be found. Some fields may be missing or have incorrect data.
   GitHub Metadata: Error processing value 'description':
  Liquid Exception: No repo name found. Specify using PAGES_REPO_NWO environment variables, 'repository' in your configuration, or set up an 'origin' git remote pointing to your github.com repository. in /_layouts/post.html
             ERROR: YOUR SITE COULD NOT BE BUILT:
                    ------------------------------------
                    No repo name found. Specify using PAGES_REPO_NWO environment variables, 'repository' in your configuration, or set up an 'origin' git remote pointing to your github.com repository.
```

大意大概是需要指向我自己的GitHub repository吧

然后我这里考虑直接把jekyll-theme-next文件夹里的所有的文件直接拷贝到我自己的blog仓库(之前创建了一个空的只有readme的文件的仓库名为luoboyala.github.io)里了

再次bundle install一遍,发现没有问题,开始bundle exec jekyll server仍然是上边的错误,根据提示开始修改config文件中的url

```yml
url:https://luoboyala.github.io
```

报错如下:

```sh
jekyll 3.7.3 | Error:  (F:/Github/luoboyala.github.io/_config.yml): could not find expected ':' while scanning a simple key at line 17 column 1
```

很明显是一个空格的原因吧...

```yml
url: https://luoboyala.github.io
```

好的还是报错了,发现问题在于没有初始化git仓库,这个虽然是一个git仓库,但是应该是缺少了git authentication  
解决办法只需要:

```sh
$ git init
$ bundle exec jekyll server
```

## 其它配置

见说明中,慢慢来吧

## 其它补充

喜欢这个作者的[next博客](https://notes.wanghao.work/),学习一下吧...