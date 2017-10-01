package org.redin.seckill.po;

import lombok.Data;

import java.util.Date;

/**
 * Author: Redinw
 * Description:秒杀成功表实体
 */
@Data
public class SuccessKilled {
    private long seckillId;
    private long userPhone;
    private short state;
    private Date createTime;
    private Seckill seckill;
}
