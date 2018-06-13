package com.features.salesman;

import com.dataanalytic.DataAnalytic;
import com.listener.FileListener;
import com.parser.DefaultParser;

import java.util.List;

public class SalesmanFileListener implements FileListener {

    private SalesmanData salesmanData = SalesmanData.getInstance();
    private DataAnalytic dataAnalytic = new DataAnalytic();
    private static final String SALESMAN_ID = "002";

    @Override
    public void proccess(List<String> lines) {
        salesmanData.add(DefaultParser.parseWithDefaultSplitter(lines, SALESMAN_ID));
        this.dataAnalytic.analyseResult();
    }
}
