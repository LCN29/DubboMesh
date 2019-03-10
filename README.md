# 阿里巴巴第四届天池比赛初赛题目

## 1. 项目说明
这个仓库中总共有2个项目，其中agent-demo是参赛者发挥的地方，services是provider和consumer的地方，不能进行修改。

## 2. 启动项目
需要在电脑安装[etcd](https://github.com/coreos/etcd/releases) ,选择合适自己系统的，进行按照即可

## 3. 配置services中的Provider和Consumer的启动参数

|  		 | JVM启动参数|
| :-: | :-: |
| consumer        | -Xms1536M -Xmx1536M -Dtype=consumer -Dserver.port=20000 -Detcd.url=http://127.0.0.1:2379 -Dlogs.dir=/yourLogPath|
| small_provider  | -Xms512M  -Xmx512M  -Dtype=provider -Dserver.port=30000 -Ddubbo.protocol.port=20889 -Detcd.url=http://127.0.0.1:2379 -Dlogs.dir=/yourLogPath|
| medium_provider | -Xms1536M -Xmx1536M -Dtype=provider -Dserver.port=30001 -Ddubbo.protocol.port=20890 -Detcd.url=http://127.0.0.1:2379 -Dlogs.dir=/yourLogPath|
| large_provider  | -Xms2560M -Xmx2560M -Dtype=provider -Dserver.port=30002 -Ddubbo.protocol.port=20891 -Detcd.url=http://127.0.0.1:2379 -Dlogs.dir=/yourLogPath|


## 4. 配置agent-demo的Provider-Agent和Consumer-Agent的启动参数

|  		| JVM启动参数|
| :-: | :-: |
| consumer_agent  | -Dtype=consumer -Dserver.port=20000 -Dlogs.dir=/yourLogPath|
| provider_agent  | -Dtype=provider -Dserver.port=30000 -Ddubbo.protocol.port=20889 -Dlogs.dir=/yourLogPath|

## 5. 修改一下项目中的错
在services中的 com.alibaba.dubbo.performance.demo.agent.HelloController的第84行左右的代码由String s = new String(bytes); 改成String s = new String(bytes).trim();

## 6. 验证
2个项目都启动了，访问 `http://localhost:8087/invoke` 如果返回了Ok,就是成功了
