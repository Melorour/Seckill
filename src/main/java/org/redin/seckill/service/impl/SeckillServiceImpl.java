package org.redin.seckill.service.impl;

import org.redin.seckill.dao.SeckillMapper;
import org.redin.seckill.dao.SuccessKilledMapper;
import org.redin.seckill.dao.cache.RedisDao;
import org.redin.seckill.enums.SeckillStateEnum;
import org.redin.seckill.exception.RepeatKillException;
import org.redin.seckill.exception.SeckillClosedException;
import org.redin.seckill.exception.SeckillException;
import org.redin.seckill.po.Seckill;
import org.redin.seckill.po.SuccessKilled;
import org.redin.seckill.service.ISeckillService;
import org.redin.seckill.dto.Exposer;
import org.redin.seckill.dto.SeckillExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author: Redinw
 * Description:
 */
@Service
public class SeckillServiceImpl implements ISeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String salt = "test";

    @Resource
    private SeckillMapper seckillMapper;

    @Resource
    private SuccessKilledMapper successKilledMapper;

    @Resource
    private RedisDao redisDao;

    @Override
    public List<Seckill> getAll() {
        return seckillMapper.queryAll(0, 4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    @Override
    public Exposer exoportSeckillUrl(long seckillId) {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if(seckill==null){
            seckill=seckillMapper.queryById(seckillId);
            if(seckill==null){
                return new Exposer(false,seckillId);
            }else{
                redisDao.putSeckill(seckill);
            }
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();

        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    @Transactional //开启事务
    public SeckillExecution executeSeckill(long seckllId, long userPhone, String md5) {
        if (md5 == null || !md5.equals(getMD5(seckllId))) {
            throw new SeckillException("seckill data rewirite");
        }

        Date nowTime = new Date();
        //执行秒杀逻辑=减库存+记录购买行为
        try {
                //记录购买行为
                int insertCount = successKilledMapper.insertSuccessKilled(seckllId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    int updateCount = seckillMapper.reduceNumber(seckllId, nowTime);
                    if (updateCount <= 0) {
                        //没有更新到记录
                        throw new SeckillClosedException("seckill is closed");
                    } else {
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckllId,userPhone);
                    return new SeckillExecution(seckllId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillClosedException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译器异常转换为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }

    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return seckillId + md5;
    }
}
