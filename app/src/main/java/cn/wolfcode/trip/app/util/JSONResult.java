package cn.wolfcode.trip.app.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JSONResult {
    //记录是否成功
    private boolean success = true;
    //错误消息
    private String errorMsg;
    //对象
    private Object object;
}
