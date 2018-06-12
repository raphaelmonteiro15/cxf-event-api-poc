package com.listeners;

import com.data.SalesmanData;
import com.parser.DefaultParser;

import java.util.List;

public class SalesmanFileListener implements FileListener {

    private SalesmanData salesmanData = SalesmanData.getInstance();
    private static final String SALESMAN_ID = "002";

    @Override
    public void proccess(List<String> lines) {
        salesmanData.add(DefaultParser.parseWithDefaultSplitter(lines, SALESMAN_ID));
    }
}
