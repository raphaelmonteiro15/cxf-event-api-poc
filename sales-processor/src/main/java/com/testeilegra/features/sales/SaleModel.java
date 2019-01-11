package com.testeilegra.features.sales;

import java.util.List;

public class SaleModel {
    private String id;
    private String numberSale;
    private String sallerName;
    private List<ItemModel> itens;
    private Double saleValue;

    @java.beans.ConstructorProperties({"id", "numberSale", "sallerName", "itens", "saleValue"})
    SaleModel(String id, String numberSale, String sallerName, List<ItemModel> itens, Double saleValue) {
        this.id = id;
        this.numberSale = numberSale;
        this.sallerName = sallerName;
        this.itens = itens;
        this.saleValue = saleValue;
    }

    public SaleModel() {
    }

    public static SaleModelBuilder builder() {
        return new SaleModelBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getNumberSale() {
        return this.numberSale;
    }

    public String getSallerName() {
        return this.sallerName;
    }

    public List<ItemModel> getItens() {
        return this.itens;
    }

    public Double getSaleValue() {
        return this.saleValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumberSale(String numberSale) {
        this.numberSale = numberSale;
    }

    public void setSallerName(String sallerName) {
        this.sallerName = sallerName;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }

    public static class SaleModelBuilder {
        private String id;
        private String numberSale;
        private String sallerName;
        private List<ItemModel> itens;
        private Double saleValue;

        SaleModelBuilder() {
        }

        public SaleModelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SaleModelBuilder numberSale(String numberSale) {
            this.numberSale = numberSale;
            return this;
        }

        public SaleModelBuilder sallerName(String sallerName) {
            this.sallerName = sallerName;
            return this;
        }

        public SaleModelBuilder itens(List<ItemModel> itens) {
            this.itens = itens;
            return this;
        }

        public SaleModelBuilder saleValue(Double saleValue) {
            this.saleValue = saleValue;
            return this;
        }

        public SaleModel build() {
            return new SaleModel(id, numberSale, sallerName, itens, saleValue);
        }

        public String toString() {
            return "SaleModel.SaleModelBuilder(id=" + this.id + ", numberSale=" + this.numberSale + ", sallerName=" + this.sallerName + ", itens=" + this.itens + ", saleValue=" + this.saleValue + ")";
        }
    }
}
