package com.project.adneom.services;

import com.project.adneom.wrappers.ArrayWrapper;

import java.util.List;

public interface ListService {

    List<List<Integer>> partition(List<Integer> list, final int size);
    List<List<Integer>> partition(ArrayWrapper arrayWrapper);
    String partitionWrapper(ArrayWrapper arrayWrapper);

}
