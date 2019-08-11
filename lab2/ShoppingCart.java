package ru.eltex.app.lab2;

import java.io.Serializable;
import java.util.*;

import ru.eltex.app.lab1.Products;

import java.util.LinkedList;

public class ShoppingCart <T extends Products> implements Serializable {

    private List<T> cart;
    private Set<UUID> uuids;

    public ShoppingCart(){
        //this.cart = Collections.synchronizedList(new LinkedList<T>());
        this.cart = new ArrayList<>();
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
        for (T val: cart){
            val.read();
        }
    }

  /*  public void show_short(){
        for (T val: cart){
            System.out.println(val.name+"("+val.price+")");
        }
    }
*/
    public boolean isExistsUUID(UUID id){
        return uuids.contains(id);
    }

}
