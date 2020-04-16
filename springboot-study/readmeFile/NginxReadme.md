Nginx学习笔记

Nginx简介
    Nginx是由伊戈尔·赛索耶夫为俄罗斯访问量第二的Rambler.ru站点（俄文：Рамблер）开发的。Nginx是一款轻量级的Web 服务器/反向代理服务器。其特点是占有内存少，并发能力强。
Nginx安装
一, 通过yum方式安装nginx
    安装依赖
      yum -y install gcc pcre-devel zlib-developenssl openssl-devel
    安装nginx
      yum install nginx
    查看版本号
      nginx -v
    查看安装目录
     rpm -ql nginx
    启动nginx
     systemctl start nginx
    加入开机自启动
     systemctl enable nginx
    查看nginx状态
     systemctl status nginx
   nginx配置文件
     /etc/nginx/nginx.conf

二，通过安装包安装
  选择一个目录运行命令下载安装包
    wget http://nginx.org/download/nginx-1.9.9.tar.gz
  解压
    tar -zxvf nginx-1.9.9.tar.gz
  重命名一下
    mv nginx-1.9.9 nginx
  配置nginx进入
    cd nginx
    ./configure
    make && install make
  启动nginx
    cd /usr/local/nginx/sbin
    ./nginx 
