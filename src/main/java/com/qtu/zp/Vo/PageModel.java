package com.qtu.zp.Vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/14 19:19
 */
public class PageModel implements Serializable{
    //当前页
    private long total;
    //当前页记录
    private List rows;

    public PageModel(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}

