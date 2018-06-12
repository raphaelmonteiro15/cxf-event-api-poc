package com.model;

public class ItemModel {
    private String idItem;
    private String quantidade;
    private String preco;
    private Double agrupaValorItem;

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Double getAgrupaValorItem() {
        return agrupaValorItem;
    }

    public void setAgrupaValorItem(Double agrupaValorItem) {
        this.agrupaValorItem = agrupaValorItem;
    }

    @java.beans.ConstructorProperties({"idItem", "quantidade", "preco", "agrupaValorItem"})
    ItemModel(String idItem, String quantidade, String preco, Double agrupaValorItem) {
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.preco = preco;
        this.agrupaValorItem = agrupaValorItem;
    }

    public static ItemModelBuilder builder() {
        return new ItemModelBuilder();
    }

    public static class ItemModelBuilder {
        private String idItem;
        private String quantidade;
        private String preco;
        private Double agrupaValorItem;

        ItemModelBuilder() {
        }

        public ItemModelBuilder idItem(String idItem) {
            this.idItem = idItem;
            return this;
        }

        public ItemModelBuilder quantidade(String quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemModelBuilder preco(String preco) {
            this.preco = preco;
            return this;
        }

        public ItemModelBuilder agrupaValorItem(Double agrupaValorItem) {
            this.agrupaValorItem = agrupaValorItem;
            return this;
        }

        public ItemModel build() {
            return new ItemModel(idItem, quantidade, preco, agrupaValorItem);
        }

        public String toString() {
            return "ItemModel.ItemModelBuilder(idItem=" + this.idItem + ", quantidade=" + this.quantidade + ", preco=" + this.preco + ", agrupaValorItem=" + this.agrupaValorItem + ")";
        }
    }
}
