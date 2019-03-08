package com.oumuv.order.commons;

import java.io.Serializable;

/***
 *<pre>
 *  返回参数
 *</pre>
 * @ClassName: Page
 * @Auther: oyf
 * @Date: 2019-03-06 15:21
 * @version : V1.0
 */
public class Page<T> implements Serializable {

    private T page;
    private String code = "0";
    private String msg = "ok";

    public Page() {
    }

    public Page(T page) {
        this.page = page;
    }

    public Page(T page, String code, String msg) {
        this.page = page;
        this.code = code;
        this.msg = msg;
    }

    public T getPage() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
