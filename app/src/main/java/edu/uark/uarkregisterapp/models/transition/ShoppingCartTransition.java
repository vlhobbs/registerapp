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
        this.count = shoppingCartParcel.readInt();
        this.totalPrice = shoppingCartParcel.readInt();
        cart = new ArrayList<Product>();
        shoppingCartParcel.readList(cart, null);
    }

    public void add(Product input, int quantity)
    {
        for(int i = 0; i < quantity; i++)
        {
            cart.add(input);
        }
        count += quantity;
        totalPrice += (quantity * input.getCost());
    }

    public void remove(Product input, int quantity)
    {
        for(int i = 0; i < quantity; i++)
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
        destination.writeInt(this.totalPrice);
        destination.writeInt(this.count);
        destination.writeList(cart);
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
