package com.features.sales;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SalesService {

    private SalesData salesData;

    public SalesService() {
        this.salesData = SalesData.getInstance();
    }

    public List<String> getWorstSaller() {
        var sales = new ArrayList<>(salesData.getSaleModel());
        var salers = sales.stream().map(SaleModel::getSallerName).distinct().collect(Collectors.toList());
        var salersValues = salers.stream().map(getSalesOfSaller(sales)).collect(Collectors.toList());
        return salersValues.stream().filter(s -> s.getValue().equals(salersValues.stream()
                .map(SellerValue::getValue).min(Double::compare).get())).collect(Collectors.toList())
                .stream().map(SellerValue::getSalesman).collect(Collectors.toList());
    }

    private Function<String, SellerValue> getSalesOfSaller(ArrayList<SaleModel> sales) {
        return sl -> {
            List<SaleModel> saleModelStream = sales.stream().filter(getSallerFromSallers(sl)).collect(Collectors.toList());
            return SellerValue.builder()
                    .salesman(sl)
                    .value(saleModelStream.stream().mapToDouble(SaleModel::getSaleValue).sum())
                    .build();
        };
    }

    private Predicate<SaleModel> getSallerFromSallers(String sl) {
        return t -> t.getSallerName().equals(sl);
    }

    public String getBestSalling() {
        return salesData.getSaleModel()
                .stream().max(Comparator.comparing(SaleModel::getSaleValue))
                .orElse(new SaleModel()).getNumberSale();
    }
}
