package com.project.adneom.services;

import com.google.gson.Gson;
import com.project.adneom.exceptions.CustomParameterException;
import com.project.adneom.utils.ListUtil;
import com.project.adneom.wrappers.ArrayWrapper;
import com.project.adneom.wrappers.ItemsListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private Gson gson;

 /**
-Return of all array items
  -Items placed in the tables first at the maximum of the parameter size, then at the maximum of the lower size,
  until the placement of all of them (see j-unit tests)
*/

    @Override
    public List<List<Integer>> partition(final List<Integer> list, final int size) {
        try{
            validateParameters(list, size);
        }catch(CustomParameterException ex){
            ex.printStackTrace();
            return null;
        }
        final ListUtil listUtil = new ListUtil(list);
        final List<List<Integer>> itemsList = listUtil.getItemsList(size);
        return itemsList;
    }

    @Override
    public List<List<Integer>> partition(final ArrayWrapper arrayWrapper) {
        try{
            validateArrayWrapper(arrayWrapper);
        }catch(CustomParameterException ex){
            ex.printStackTrace();
            return null;
        }
        final List<Integer> list = Arrays.stream(arrayWrapper.getInts())
                .boxed()
                .collect(Collectors.toList());
        return partition(list, arrayWrapper.getSize());
    }

    /**
     *
     * @param arrayWrapper
     * @return ItemsListWrapper String in Json format
     * For jms utilisation
     */
    @Override
    public String partitionWrapper(final ArrayWrapper arrayWrapper) {
        try{
            validateArrayWrapper(arrayWrapper);
        }catch(CustomParameterException ex){
            ex.printStackTrace();
            return null;
        }
        final List<List<Integer>> itemsList = partition(arrayWrapper);
        final ItemsListWrapper itemsListWrapper = new ItemsListWrapper(itemsList);
        return gson.toJson(itemsListWrapper);
    }

    private void validateParameters(final List<Integer> list, final int size){
        if(list.isEmpty() || size <= 0){
            throw new CustomParameterException("parameters are not valid");
        }
    }

    private void validateArrayWrapper(final ArrayWrapper arrayWrapper){
        if(arrayWrapper.getInts() == null || arrayWrapper.getInts().length == 0 || arrayWrapper.getSize() <= 0){
            throw new CustomParameterException("parameters are not valid");
        }
    }

}
