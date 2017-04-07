package ofly.ep.test.entity;

import java.util.Date;

public class Log {
	/**
     * 日志id
     */
    private Integer id;

    /**
     * 当前操作人id
     */
    private String loginAccount;

    /**
     * 当前操作人ip
     */
    private String loginIp;

    /**
     * 操作请求的链接
     */
    private String actionUrl;

    /**
     * 执行的模块
     */
    private String module;

    /**
     * 执行的方法
     */
    private String method;

    /**
     * 执行操作时间
     */
    private Long actionTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 执行的时间
     */
    private Date gmtCreate;

    /**
     * 该操作状态，1表示成功，-1表示失败！
     */
    private Short state;
}
