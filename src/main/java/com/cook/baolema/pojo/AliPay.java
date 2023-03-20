package com.cook.baolema.pojo;

import lombok.Data;

@Data
public class AliPay {
    private String traceNo;
    private Float totalAmount;
    private String subject;
    private String alipayTraceNo;
}
