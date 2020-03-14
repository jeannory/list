package com.project.adneom.services;

import com.project.adneom.utils.ListUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListServiceImpl implements ListService {

 /**
-Retour de tous les éléments du tableau
-Eléments placés dans les tableaux d'abord au maximum de la taille en paramètre, puis au maximum de la taille inférieur,
    jusqu'au placement de tous les éléments (voir les exemples des tests unitaires)
*/

    @Override
    public List<List<Integer>> partition(List<Integer> list, final int size) {
        final ListUtil listUtil = new ListUtil(list);
        final List<List<Integer>> itemsList = listUtil.getItemsList(size);
        return itemsList;
    }

}
