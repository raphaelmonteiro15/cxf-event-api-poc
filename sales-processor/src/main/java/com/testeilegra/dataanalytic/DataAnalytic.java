package com.testeilegra.dataanalytic;

import com.testeilegra.features.customer.CustomerService;
import com.testeilegra.features.sales.SalesService;
import com.testeilegra.features.salesman.SalesmanService;
import com.testeilegra.file.FileUtil;

public class DataAnalytic {
    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SalesService salesService;
    private FileUtil fileUtil;
    //private static final Path path = Paths.get("%HOMEPATH%/data/out/output.done.dat");

    public DataAnalytic() {
        this.customerService = new CustomerService();
        this.salesmanService = new SalesmanService();
        this.salesService = new SalesService();
        this.fileUtil = new FileUtil();
    }

    public void analyseResult() {
        FormModel formModel = FormModel.builder()
                .AmountClients(customerService.getAmountClient())
                .AmountSalesman(salesmanService.getAmountSalesman())
                .idMostExpensiveSale(salesService.getBestSalling())
                .worstSalesmanEver(salesService.getWorstSaller())
                .build();

        System.out.println(buildContent(formModel));
    }


    private String buildContent(FormModel formModel){
        return new StringBuilder().append("Amount of customers: ").append(formModel.getAmountClients()).append("\n")
                .append("Amount of salesman: ").append(formModel.getAmountSalesman()).append("\n")
                .append("Best Selling: ").append(formModel.getIdMostExpensiveSale()).append("\n")
                .append("Worst Salesman ever: ").append(formModel.getWorstSalesmanEver()).append("\n")
                .toString();
    }
}
