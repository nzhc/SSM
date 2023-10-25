package org.example.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;

    // 一个订单一个客户，一对一
    private Customer customer;
}
