package edu.uark.uarkregisterapp.models.api;
import java.util.ArrayList;

import edu.uark.uarkregisterapp.models.transition.ShoppingCartTransition;

public class ShoppingCart
{
    private ArrayList<Product> cart;
    private int count;
    private int totalPrice;
    public ShoppingCart()
    {
        cart = new ArrayList();
        count = 0;
        totalPrice = 0;
    }
    public ShoppingCart (ShoppingCartTransition ShoppingT)
    {
        cart = ShoppingT.getList();
        count = ShoppingT.getCount();
        totalPrice = ShoppingT.getTotalPrice();
    }
    public void add(Product input, int quantity)
    {
        for(int i = 1; i < quantity; i++)
        {
            cart.add(input);
        }
        count += quantity;
        totalPrice += (quantity * input.getCost());
    }

    public void remove(Product input, int quantity)
    {
        for(int i = 1; i < quantity; i++)
        {
            cart.remove(input);
        }
        count -= quantity;
        totalPrice -= (quantity * input.getCost());
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public int getCount()
    {
        return count;
    }

    public ArrayList<Product> getList()
    {
        return cart;
    }
}