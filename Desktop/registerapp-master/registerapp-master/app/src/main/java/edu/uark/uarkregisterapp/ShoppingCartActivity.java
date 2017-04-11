package edu.uark.uarkregisterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.uark.uarkregisterapp.adapters.ProductListAdapter;
import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ShoppingCart;
import edu.uark.uarkregisterapp.models.api.services.ShoppingService;
import edu.uark.uarkregisterapp.models.api.services.ProductService;
import edu.uark.uarkregisterapp.models.transition.ProductTransition;

public class ShoppingCartActivity extends AppCompatActivity {
    private ShoppingCart myCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        myCart = new ShoppingCart();
    }

    private class RetrieveShoppingTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            products.clear();
            products.addAll(
                    (new ShoppingService()).getProducts()
            );

            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            productListAdapter.notifyDataSetChanged();
            loadingProductsAlert.dismiss();
        }
    }
    private List<Product> products;
    private AlertDialog loadingProductsAlert;
    private ProductListAdapter productListAdapter;

}