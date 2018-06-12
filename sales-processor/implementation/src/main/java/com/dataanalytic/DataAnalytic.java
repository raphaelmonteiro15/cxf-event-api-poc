package com.dataanalytic;

import com.model.FormModel;
import com.service.CustomerService;
import com.service.SalesService;
import com.service.SalesmanService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataAnalytic {
    private CustomerService customerService = new CustomerService();
    private SalesmanService salesmanService = new SalesmanService();
    private SalesService salesService = new SalesService();
    //private Path path = Paths.get("%HOMEPATH%/data/out/output.done.dat");

    public void formModel() {
        var formModel = FormModel.builder()
                .AmountClients(customerService.getAmountClient())
                .AmountSalesman(salesmanService.getAmountSalesman())
                .idMostExpensiveSale(salesService.getBestSalling())
                .worstSalesmanEver(salesService.worstSeller())
                .build();

        System.out.println(customerService.getAmountClient());
        System.out.println(salesmanService.getAmountSalesman());
        System.out.println(salesService.getBestSalling());
        System.out.println(salesService.worstSeller());


//        try(BufferedWriter writer = Files.newBufferedWriter(path)){
//            writer.write(formModel.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
