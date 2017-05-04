package edu.uark.uarkregisterapp.models.transition;

/**
 * Created by Jon McClain on 4/13/2017.
 */
import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.List;

import edu.uark.uarkregisterapp.commands.converters.ByteToUUIDConverterCommand;
import edu.uark.uarkregisterapp.commands.converters.UUIDToByteConverterCommand;
import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ShoppingCart;

public class ShoppingCartTransition implements Parcelable{
    private ArrayList<Product> cart;
    private ArrayList<ProductTransition> passCart;
    private int count;
    private int totalPrice;
    public ShoppingCartTransition()
    {
        cart = new ArrayList();
        count = 0;
        totalPrice = 0;
    }
    public ShoppingCartTransition(ShoppingCart inCart)
    {
        cart = inCart.getList();
        count = inCart.getCount();
        totalPrice = inCart.getTotalPrice();
    }

    public ShoppingCartTransition(Parcel shoppingCartParcel)
    {
        passCart = new ArrayList<ProductTransition>();
        this.count = shoppingCartParcel.readInt();
        this.totalPrice = shoppingCartParcel.readInt();
        cart = new ArrayList<Product>();
        //shoppingCartParcel.readList(cart, getClass().getClassLoader());
       /* passCart = shoppingCartParcel.readArrayList(getClass().getClassLoader());
        Product tempItem;
        cart.clear();
        for(int i = 0; i < passCart.size(); i++)
        {
            tempItem = new Product(passCart.get(i));
            cart.add(tempItem);
        } */
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        passCart = new ArrayList<ProductTransition>();
        passCart.clear();
        destination.writeInt(this.totalPrice);
        destination.writeInt(this.count);
       /* ProductTransition tempItem;
        for(int i = 0; i < cart.size(); i++)
        {
            tempItem = new ProductTransition(cart.get(i));
            passCart.add(tempItem);
        }
        List<ProductTransition> listCart =  passCart;
        destination.writeList(listCart); */

     //   destination.writeList(cart);
    }
    public static final Parcelable.Creator<ShoppingCartTransition> CREATOR = new Parcelable.Creator<ShoppingCartTransition>() {
        public ShoppingCartTransition createFromParcel(Parcel employeeTransitionParcel) {
            return new ShoppingCartTransition(employeeTransitionParcel);
        }

        public ShoppingCartTransition[] newArray(int size) {
            return new ShoppingCartTransition[size];
        }

    };
}
