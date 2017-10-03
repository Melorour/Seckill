package org.redin.seckill.exception;

/**
 * Author: Redinw
 * Description:
 */
public class RepeatKillException extends  SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
