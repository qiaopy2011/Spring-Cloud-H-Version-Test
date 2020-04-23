package com.bdqn.springcloud.enums;

/**
 * @author qiaopy
 * @date 2020/3/20 09:35
 */
public enum ResultEnum {

        SUCCESS(200, "SUCCESS"), FAILED(444, "FAILED");
        // 成员变量
        private int code;
        private String status;
        // 构造方法
        private ResultEnum(int code, String status) {
            this.code = code;
            this.status = status;
        }
        // 普通方法
     /*   public static int getName(String status) {
            for (ResultEnum c : ResultEnum.values()) {
                if (c.getStatus().equals(status)) {
                    return c.code;
                }
            }
            return -1;
        }*/

    public int getCode() {
        return code;
    }

  /*  public void setCode(int code) {
        this.code = code;
    }*/

    public String getStatus() {
        return status;
    }

   /* public void setStatus(String status) {
        this.status = status;
    }*/
}
