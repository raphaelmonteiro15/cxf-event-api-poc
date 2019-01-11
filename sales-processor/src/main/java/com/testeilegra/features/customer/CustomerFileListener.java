package com.testeilegra.features.customer;

import com.testeilegra.dataanalytic.DataAnalytic;
import com.testeilegra.listener.FileListener;
import com.testeilegra.parser.DefaultParser;

import java.util.List;

public class CustomerFileListener extends FileListener {
    private static final String CUSTOMER_ID = "001";
    private DataAnalytic dataAnalytic = new DataAnalytic();

    private CustomerData customerData;

    public CustomerFileListener() {
        this.customerData = CustomerData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.customerData.add(DefaultParser.parseWithDefaultSplitter(lines, CUSTOMER_ID));
        dataAnalytic.analyseResult();
    }
}
