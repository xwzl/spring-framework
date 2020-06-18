package com.spring.test.aspect;

public class TestBean {
    private String message = "test bean";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void test(){
        System.out.println(this.message);
    }
}
