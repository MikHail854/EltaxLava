package ru.eltex.app.lab2;

import java.util.*;

import ru.eltex.app.lab1.Products;

import java.util.LinkedList;

public class ShoppingCart <T extends Products> {

    private List<T> cart;
    private Set<UUID> uuids;

    public ShoppingCart(){
        this.cart = new LinkedList<>();
        this.uuids = new HashSet<>();
    }


    public boolean add(T products){
        uuids.add(products.getUUID());
        return this.cart.add(products);
    }

    void delete(T products){
        this.cart.remove(products);
    }

    public void show(){
        for (Products val: cart){
            val.read();
        }
    }

    public boolean isExistsUUID(UUID id){
        return uuids.contains(id);
    }

}
