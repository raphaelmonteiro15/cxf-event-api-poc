package com.features.sales;

import com.dataanalytic.DataAnalytic;
import com.features.customer.SaleTextParser;
import com.listener.FileListener;

import java.util.List;

public class SaleFileListener extends FileListener {
    private SalesData salesData;
    private DataAnalytic dataAnalytic = new DataAnalytic();

    public SaleFileListener() {
        this.salesData = SalesData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.salesData.add(SaleTextParser.parseSale(lines));
        this.dataAnalytic.analyseResult();
    }
}
