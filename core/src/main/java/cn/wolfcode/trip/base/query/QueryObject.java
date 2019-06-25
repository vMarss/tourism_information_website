package cn.wolfcode.trip.base.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//把分页的信息给封装好
@ToString
@Setter@Getter
public class QueryObject {
    private int currentPage = 1;

    private int pageSize = 5;

    //必须与表单的name一致，不然接收不了
    private String keyword;
}
