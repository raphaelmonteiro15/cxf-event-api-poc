package com.model;

import java.util.List;

public class FormModel {
    private Long AmountClients;
    private Long AmountSalesman;
    private String idMostExpensiveSale;
    protected List<String> worstSalesmanEver;

    @java.beans.ConstructorProperties({"AmountClients", "AmountSalesman", "idMostExpensiveSale", "worstSalesmanEver"})
    FormModel(Long AmountClients, Long AmountSalesman, String idMostExpensiveSale, List<String> worstSalesmanEver) {
        this.AmountClients = AmountClients;
        this.AmountSalesman = AmountSalesman;
        this.idMostExpensiveSale = idMostExpensiveSale;
        this.worstSalesmanEver = worstSalesmanEver;
    }

    public static FormModelBuilder builder() {
        return new FormModelBuilder();
    }

    public static class FormModelBuilder {
        private Long AmountClients;
        private Long AmountSalesman;
        private String idMostExpensiveSale;
        private List<String> worstSalesmanEver;

        FormModelBuilder() {
        }

        public FormModelBuilder AmountClients(Long AmountClients) {
            this.AmountClients = AmountClients;
            return this;
        }

        public FormModelBuilder AmountSalesman(Long AmountSalesman) {
            this.AmountSalesman = AmountSalesman;
            return this;
        }

        public FormModelBuilder idMostExpensiveSale(String idMostExpensiveSale) {
            this.idMostExpensiveSale = idMostExpensiveSale;
            return this;
        }

        public FormModelBuilder worstSalesmanEver(List<String> worstSalesmanEver) {
            this.worstSalesmanEver = worstSalesmanEver;
            return this;
        }

        public FormModel build() {
            return new FormModel(AmountClients, AmountSalesman, idMostExpensiveSale, worstSalesmanEver);
        }

        public String toString() {
            return "FormModel.FormModelBuilder(AmountClients=" + this.AmountClients + ", AmountSalesman=" + this.AmountSalesman + ", idMostExpensiveSale=" + this.idMostExpensiveSale + ", worstSalesmanEver=" + this.worstSalesmanEver + ")";
        }
    }
}
