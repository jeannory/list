package com.project.adneom.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    private static List<Integer> items;

    public ListUtil(List<Integer> items) {
        this.items = items;
    }

    public List<List<Integer>> getItemsList(final int size) {

        final int amount = items.size();

        final List<List<Integer>> itemsList = new ArrayList<>();
            int fillingNumber = getFillingNumber(amount, size);
            int indice = 0;
            for(int k = 0; k < fillingNumber; k++){
                final List<Integer> newItems = new ArrayList<>();

                for (int j = 0; j < size; j++) {
                    //end of list filling
                    if(indice == (amount)){
                        break;
                    }else{
                        newItems.add(this.items.get(indice));
                        indice += 1;
                    }
                }

                if(!newItems.isEmpty()){
                    itemsList.add(newItems);
                }
            }

        return itemsList;
    }

    private int getModulo(int amount, int size) {
        return amount % size;
    }

    //get the number of sub lists of items
    private int getFillingNumber(int amount, int size){
        int modulo = getModulo(amount, size);
        if(modulo == 0){
            return amount/ size;
        }
        else{
            return (amount/ size) + modulo;
        }
    }
}
