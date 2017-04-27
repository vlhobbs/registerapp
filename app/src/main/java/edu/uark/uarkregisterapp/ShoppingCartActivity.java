package edu.uark.uarkregisterapp;

import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uark.uarkregisterapp.adapters.ShoppingListAdapter;
import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ShoppingCart;
import edu.uark.uarkregisterapp.models.api.services.ShoppingService;
import edu.uark.uarkregisterapp.models.api.services.ProductService;
import edu.uark.uarkregisterapp.models.transition.EmployeeTransition;
import edu.uark.uarkregisterapp.models.transition.ProductTransition;
import edu.uark.uarkregisterapp.models.transition.ShoppingCartTransition;

public class ShoppingCartActivity extends AppCompatActivity {
    private ShoppingCartTransition myCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myCart = this.getIntent().getParcelableExtra("Shopping Cart");
        this.curEmployee = this.getIntent().getParcelableExtra(this.getString(R.string.intent_extra_employee));
        setContentView(R.layout.activity_shopping_cart);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        this.products = myCart.getList();
        this.shoppingListAdapter = new ShoppingListAdapter(this, this.products);

        this.getShoppingListView().setAdapter(this.shoppingListAdapter);
        this.getShoppingListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getApplicationContext(), ProductViewActivity.class);

            intent.putExtra(
                    getString(R.string.intent_extra_product),
                    new ProductTransition((Product) getShoppingListView().getItemAtPosition(position))

            );
            intent.putExtra("Shopping Cart", myCart);
            intent.putExtra(
                    getString(R.string.intent_extra_employee),
                    curEmployee
            );
            startActivity(intent);
        }
    });


    this.loadingShoppingAlert = new AlertDialog.Builder(this).
    setMessage(R.string.alert_dialog_products_loading).
    create();
}
    private ListView getShoppingListView() {
        return (ListView) this.findViewById(R.id.list_view_shoppingcart);
    }

    public void startTransactionButtonOnClick(View view)
    {
        this.displayFunctionalityNotAvailableDialog();
    }

    private void displayFunctionalityNotAvailableDialog() {
        new AlertDialog.Builder(this).
                setMessage(R.string.alert_dialog_functionality_not_available).
                setPositiveButton(
                        R.string.button_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        }
                ).
                create().
                show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.text_total_price);
        textView.setText("Total Price: " + myCart.getTotalPrice());
        textView = (TextView) findViewById(R.id.text_total_products);
        textView.setText("Number of Products: " + myCart.getCount());
        this.loadingShoppingAlert.show();
        (new RetrieveShoppingTask()).execute();
    }

private class RetrieveShoppingTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            products.clear();
            products.addAll(myCart.getList());
            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            shoppingListAdapter.notifyDataSetChanged();
            loadingShoppingAlert.dismiss();
        }
    }
    private List<Product> products;
    private AlertDialog loadingShoppingAlert;
    private ShoppingListAdapter shoppingListAdapter;
    private EmployeeTransition curEmployee;

}
