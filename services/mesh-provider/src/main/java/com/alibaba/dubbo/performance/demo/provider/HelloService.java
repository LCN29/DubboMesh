package com.alibaba.dubbo.performance.demo.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloService implements IHelloService {

    private long count;

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService() {

    }

    @Override
    public int hash(String str) throws Exception {
        String salt = System.getProperty("salt");
        int hashCode = (str + salt).hashCode();
        logger.info("Provider处理次数----------->{}, 返回结果为--------->{}", ++count, hashCode);
        sleep(50);
        return hashCode;
    }

    private void sleep(long duration) throws Exception {
        Thread.sleep(duration);
    }
}
