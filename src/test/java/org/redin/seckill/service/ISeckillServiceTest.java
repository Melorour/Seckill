package org.redin.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redin.seckill.po.Seckill;
import org.redin.seckill.dto.Exposer;
import org.redin.seckill.dto.SeckillExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Author: Redinw
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ISeckillService seckillService;


    @Test
    public void queryAll() throws Exception {
        List<Seckill> list = seckillService.getAll();
        logger.info("list={}", list);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exoportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exoportSeckillUrl(1000L);
        logger.info("expser={}",exposer);
        //expser=Exposer(exposed=false,
        //md5=null,
        //seckillId=1000,
        //nowTime=1506951707793,
        //tartTime=1446307200000,
        //endTime=1446393600000)

        //exposed=true,
        // md5=100010459d1ff8c1056f5adc9ec5c466fb63,
        // seckillId=1000,
        // nowTime=0,
        // startTime=0,
        // endTime=0)
    }

    @Test
    public void executeSeckill() throws Exception {
        SeckillExecution seckillExcution = seckillService.executeSeckill(1000L,13783425232L,"100010459d1ff8c1056f5adc9ec5c466fb63");
        logger.info("seckillExcution={}",seckillExcution);
    }

}