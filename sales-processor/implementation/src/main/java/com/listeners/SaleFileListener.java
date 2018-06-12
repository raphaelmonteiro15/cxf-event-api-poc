package com.listeners;

import com.data.SalesData;
import com.parser.SaleTextParser;

import java.util.List;

public class SaleFileListener implements FileListener {

    private SalesData salesData;

    public SaleFileListener() {
        this.salesData = SalesData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.salesData.add(SaleTextParser.parseSale(lines));
    }
}
