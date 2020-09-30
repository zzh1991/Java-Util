package com.zzh.util.constant;

/**
 * @author zhihaozhang
 * @since 2019.11.10
 */

public enum StatusEnum {
    SUCCESS_STATUS("success"),
    FAILURE_STATUS("failure");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }
}
