# lexcoin

## 快速开始
下载nacos-server

> 在github上搜nacos ，下载安装

```
unzip nacos-server-1.0.0.zip
cd nacos/bin 

linux: sh startup.sh -m standalone
Windows: cmd startup.cmd -m standalone(双击也可以)

# 下载源码
git clone https://github.com/alibaba/Sentinel.git

# 编译打包
mvn clean package

cd sentinel-dashboard\target
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
如若 8080 端口冲突，可使用 -Dserver.port=新端口 进行设置。
```

