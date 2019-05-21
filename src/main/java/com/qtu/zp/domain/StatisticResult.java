package com.qtu.zp.domain;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/21 16:27
 */
public class StatisticResult {
    private String date;
    private Integer sum;
    private List<String> dateList;
    private List<Integer> sumList;

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<Integer> getSumList() {
        return sumList;
    }

    public void setSumList(List<Integer> sumList) {
        this.sumList = sumList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
