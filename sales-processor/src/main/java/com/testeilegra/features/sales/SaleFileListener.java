package com.testeilegra.features.sales;

import com.testeilegra.dataanalytic.DataAnalytic;
import com.testeilegra.features.customer.SaleTextParser;
import com.testeilegra.listener.FileListener;

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
