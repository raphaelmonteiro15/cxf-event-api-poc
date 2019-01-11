package com.testeilegra.features.customer;

import com.testeilegra.features.sales.ItemModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemTextParser {
    private static final String SEPARATOR = ",";

    public static List<String> parse(String text) {
        List<String> item = new ArrayList<>(Arrays.asList(text.split(SEPARATOR)));
        item.set(0, item.get(0).replace("[", ""));
        item.set(item.size() - 1, item.get(item.size() - 1).replace("]", ""));
        return item;
    }

    public static List<String> parseItens(String itens) {
        return new ArrayList<>(Arrays.asList(itens.split("-")));
    }

    public static ItemModel itemParse(List<String> itens) {
        return ItemModel.builder().idItem(itens.get(0))
                .preco(itens.get(2))
                .quantidade(itens.get(1))
                .agrupaValorItem(valorTotal(itens.get(2), itens.get(1)))
                .build();
    }

    private static Double valorTotal(String preco, String quantidade) {
        return Double.parseDouble(preco) * Double.parseDouble(quantidade);
    }
}
