package org.redin.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redin.seckill.SeckillApplication;
import org.redin.seckill.dao.SeckillMapper;
import org.redin.seckill.po.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Author: Redinw
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeckillApplication.class)
public class RedisDaoTest {
    private long id = 1001L;

    @Resource
    private  RedisDao redisDao;

    @Resource
    private SeckillMapper seckillMapper;


    @Test
    public void testSeckill() throws Exception {
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillMapper.queryById(id);
            if(seckill!=null){
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                redisDao.getSeckill(id);
                System.out.println(seckill);
            }

        }
    }


}