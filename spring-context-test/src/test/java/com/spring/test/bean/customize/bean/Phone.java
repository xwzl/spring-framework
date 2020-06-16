package com.spring.test.bean.customize.bean;

public class Phone {

    private String color;

    private int size;

    private String remark;


    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"color\":\"")
                .append(color).append('\"');
        sb.append(",\"size\":")
                .append(size);
        sb.append(",\"remark\":\"")
                .append(remark).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
