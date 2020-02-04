package com.soch.cache;

public class Exc3 {
    public static void main(String[] args) {
        System.out.println("Zad 3 - cache");

        LinkedHashMapCache cache = new LinkedHashMapCache(5);
        cache.put(1, "raz");
        cache.put(2, "dwa");
        cache.put(3, "trzy");
        cache.put(4, "cztery");
        cache.put(5, "piec");
        System.out.println(cache);
        cache.put(6, "szesc");
        cache.put(7, "siedem");
        cache.put(8, "osiem");
        System.out.println(cache);
    }
}
