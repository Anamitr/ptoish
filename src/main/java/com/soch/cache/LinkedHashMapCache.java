package com.soch.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCache extends LinkedHashMap{
    final int size;

    public LinkedHashMapCache(int size) {
        super(size);
        this.size = size;
    }

//    @Override
//    public void put(int key, Object value) {
//        this.put(key, value);
//    }
//
//    @Override
//    public Object get(int key) {
//        return this.get(key);
//    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (this.size() > this.size) {
            return true;
        } else {
            return false;
        }
    }
}
