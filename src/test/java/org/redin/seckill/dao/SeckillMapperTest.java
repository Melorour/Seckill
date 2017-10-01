package org.redin.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redin.seckill.SeckillApplication;
import org.redin.seckill.SeckillApplicationTests;
import org.redin.seckill.po.Seckill;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Author: Redinw
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeckillApplication.class)
public class SeckillMapperTest {

    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void reduceNumber() throws Exception {

    }

    @Test
    public void queryById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillMapper.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);

    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> list = seckillMapper.queryAll(2,4);
        for(Seckill seckill:list){
            System.out.println(seckill);
        }

    }

}