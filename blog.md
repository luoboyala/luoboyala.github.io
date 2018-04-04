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
```cmd
    gem install 
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