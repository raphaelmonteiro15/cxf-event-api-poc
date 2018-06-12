package com.listeners;

import com.data.CustomerData;
import com.parser.DefaultParser;

import java.util.List;

public class CustomerFileListener implements FileListener {
    private static final String CUSTOMER_ID = "001";

    private CustomerData customerData;

    public CustomerFileListener(){
        this.customerData = CustomerData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.customerData.add(DefaultParser.parseWithDefaultSplitter(lines, CUSTOMER_ID));
    }
}
