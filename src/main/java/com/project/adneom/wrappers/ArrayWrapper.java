package com.project.adneom.wrappers;

public class ArrayWrapper {

    private final int[] ints;
    private final int size;

    public ArrayWrapper(int[] ints, int size) {
        this.ints = ints;
        this.size = size;
    }

    public int[] getInts() {
        return ints;
    }

    public int getSize() {
        return size;
    }
}
