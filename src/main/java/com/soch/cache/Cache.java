package com.soch.cache;

public interface Cache {
    void put(int key, Object value) ;
    Object get(int key);
}
