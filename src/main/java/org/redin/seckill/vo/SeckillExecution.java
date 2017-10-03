package org.redin.seckill.vo;

import lombok.Data;
import org.redin.seckill.enums.SeckillStateEnum;
import org.redin.seckill.po.SuccessKilled;

/**
 * Author: Redinw
 * Description:
 */
@Data
public class SeckillExecution {

    //秒杀执行结果状态
    private long seckillId;

    //秒杀执行结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //秒杀对象
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
}
}
