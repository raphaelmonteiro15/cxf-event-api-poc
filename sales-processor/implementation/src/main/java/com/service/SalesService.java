package com.service;

import com.data.SalesData;
import com.model.SaleModel;
import com.model.SellerValue;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalesService {

    private SalesData salesData;

    public SalesService() {
        this.salesData = SalesData.getInstance();
    }

    public List<String> worstSeller(){
      List<SaleModel> getSales = salesData.getSaleModel().stream().distinct().collect(Collectors.toList());

      List<String> salers = getSales.stream().map(i -> i.getSallerName()).distinct().collect(Collectors.toList());
      salers.stream().map(sl -> getSales.stream().filter(t -> t.getSallerName().equals(sl)).collect(Collectors.toList()));

      List<SellerValue> salersValues = salers.stream().map(sl -> {
      List<SaleModel> saleModelStream = getSales.stream().filter(t -> t.getSallerName().equals(sl)).collect(Collectors.toList());
        return SellerValue.builder()
            .salesman(sl)
            .value(saleModelStream.stream().mapToDouble(s -> s.getSaleValue()).sum())
            .build();
      }).collect(Collectors.toList());

      return salersValues.stream().filter(s -> s.getValue().equals(salersValues.stream()
              .map(sv -> sv.getValue()).min(Double::compare).get())).collect(Collectors.toList())
              .stream().map(i -> i.getSalesman()).collect(Collectors.toList());
    }

    public String getBestSalling() {
        return salesData.getSaleModel().stream().max(Comparator.comparing(i -> i.getSaleValue())).get().getNumberSale();
    }
}
