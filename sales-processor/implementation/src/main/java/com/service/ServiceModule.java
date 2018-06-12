package com.service;


public class ServiceModule {

    public CustomerService customerService() {
        return new CustomerService();
    }

    public SalesService salesService() {
        return new SalesService();
    }

    public SalesmanService salesmanService() {
        return new SalesmanService();
    }

}
