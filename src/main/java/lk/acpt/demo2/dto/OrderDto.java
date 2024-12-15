package lk.acpt.demo2.dto;

import java.util.ArrayList;
import java.util.Date;

public class OrderDto {
    private String orderDate;

    private double subTotal;

    private ArrayList<OrderDetailDto> orderDetailsDtos;

    public OrderDto(String orderDate, double subTotal, ArrayList<OrderDetailDto> orderDetailsDtos) {
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.orderDetailsDtos = orderDetailsDtos;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public ArrayList<OrderDetailDto> getOrderDetailsDtos() {
        return orderDetailsDtos;
    }

    public void setOrderDetailsDto(ArrayList<OrderDetailDto> orderDetailsDto) {
        this.orderDetailsDtos = orderDetailsDtos;
    }
}
