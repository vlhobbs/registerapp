package edu.uark.uarkregisterapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Locale;
import java.util.List;
import edu.uark.uarkregisterapp.R;
import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ShoppingCart;

/**
 * Created by Jon McClain on 4/18/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter<Product>

{
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(this.getContext());
            view = inflater.inflate(R.layout.list_view_shopping_products, parent, false);
        }

        Product product = this.getItem(position);
        if (product != null) {
            TextView lookupCodeTextView = (TextView) view.findViewById(R.id.list_view_item_product_name);
            if (lookupCodeTextView != null) {
                lookupCodeTextView.setText(product.getLookupCode());
            }

            TextView costTextView = (TextView) view.findViewById(R.id.list_view_item_shopping_product);
            if (costTextView != null) {
                costTextView.setText(String.format(Locale.getDefault(), "%d", product.getCost()));
            }
        }

        return view;
    }

    public ShoppingListAdapter(Context context, List<Product> products) {
        super(context, R.layout.list_view_shopping_products, products);
    }
}
