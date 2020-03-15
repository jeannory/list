package com.project.adneom.wrappers;

import java.io.Serializable;
import java.util.List;

public class ItemsListWrapper implements Serializable {

    private final List<List<Integer>> itemsList;

    public ItemsListWrapper(List<List<Integer>> itemsList) {
        this.itemsList = itemsList;
    }

    public List<List<Integer>> getItemsList() {
        return itemsList;
    }
}
