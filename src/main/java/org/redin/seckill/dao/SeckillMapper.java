package org.redin.seckill.dao;

import org.apache.ibatis.annotations.*;
import org.redin.seckill.po.Seckill;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Author: Redinw
 * Description:
 */
@Repository
public interface SeckillMapper {

    /**
     * 减库存
     * <![CDATA[]]>
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    @Update("UPDATE seckill SET number = number-1 " +
            "WHERE seckill_id=#{seckillId} " +
            "AND start_time <= #{killTime} " +
            "AND end_time >= #{killTime} AND number>0")
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据ID查询秒杀对象
     *
     * @param seckillId
     * @return
     */

    @Select("SELECT seckill_id,name,number,start_time,end_time,create_time " +
            "FROM seckill " +
            "WHERE seckill_id=#{seckillId}")
    @ResultMap("org.redin.seckill.dao.SeckillMapper.SeckillMap")
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offet
     * @return
     */

    @Select("SELECT seckill_id,name,number,start_time,end_time,create_time FROM seckill ORDER BY create_time DESC LIMIT #{offet},#{limit}")
    @ResultMap("org.redin.seckill.dao.SeckillMapper.SeckillMap")
    List<Seckill> queryAll(@Param("offet") int offet, @Param("limit") int limit);

}
