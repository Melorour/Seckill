package org.redin.seckill.po;

import lombok.Data;

import java.util.Date;

/**
 * Author: Redinw
 * Description:秒杀库存表实体
 */
@Data
public class Seckill {
    private long seckillId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;
}
