package edu.uark.uarkregisterapp.models.api;
import java.util.ArrayList;
public class ShoppingCart
{
    ArrayList<Product> cart;
    int count;
    int totalPrice;
    ShoppingCart()
    {
        cart = new ArrayList();
        count = 0;
        totalPrice = 0;
    }

    public void add(Product input, int quantity)
    {
        cart.add(input);
        count += quantity;
        totalPrice += (quantity * input.getCost());
    }

    public void remove(Product input, int quantity)
    {
        cart.remove(input);
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