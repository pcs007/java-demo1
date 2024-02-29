package com.cen.springbootdemo.web.domain;

public class SuccessResp {
    public static final SuccessResp SUCCESS = new SuccessResp(true);
    public static final SuccessResp FAILED = new SuccessResp(false);
    private Object r;
    private boolean s;

    public SuccessResp() {
    }

    public SuccessResp(boolean success) {
        this.s = success;
    }

    public boolean isSuccess() {
        return this.s;
    }

    public Object getResult() {
        return this.r;
    }

    public void setResult(Object result) {
        this.r = result;
    }
}