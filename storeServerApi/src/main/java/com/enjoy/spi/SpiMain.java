package com.enjoy.spi;

import com.enjoy.spi.service.SpiService;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) throws IOException {
        //加载接口
        ServiceLoader<SpiService> spiLoader = ServiceLoader.load(SpiService.class);
//        ------ jdk的spi：把实现类，装入一个list中
//                ------dubbo的spi：把实现类，装入一个map中（配置文件指定一key），key指代实现类
        Iterator<SpiService> iteratorSpi = spiLoader.iterator();
        while (iteratorSpi.hasNext()) {
            SpiService spiService = iteratorSpi.next();
            spiService.sayHello();
        }
    }


}
