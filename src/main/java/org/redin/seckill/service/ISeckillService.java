package org.redin.seckill.service;

import org.redin.seckill.po.Seckill;
import org.redin.seckill.vo.Exposer;
import org.redin.seckill.vo.SeckillExecution;

import java.util.List;

/**
 * Author: Redinw
 * Description:
 */

public interface ISeckillService {

    List<Seckill> getAll();

    Seckill getById(long seckillId);

    Exposer exoportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckllId, long userPhone, String md5);


}
