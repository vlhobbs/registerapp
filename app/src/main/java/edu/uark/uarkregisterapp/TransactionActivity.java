package edu.uark.uarkregisterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ShoppingCart;
import edu.uark.uarkregisterapp.models.api.enums.ProductApiRequestStatus;
import edu.uark.uarkregisterapp.models.api.services.ProductService;
import edu.uark.uarkregisterapp.models.transition.EmployeeTransition;
import edu.uark.uarkregisterapp.models.transition.ProductTransition;
import edu.uark.uarkregisterapp.models.transition.ShoppingCartTransition;

public class TransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        this.myCart = this.getIntent().getParcelableExtra("Shopping Cart");
        this.productTransition = this.getIntent().getParcelableExtra(this.getString(R.string.intent_extra_product));
        this.curEmployee = this.getIntent().getParcelableExtra(this.getString(R.string.intent_extra_employee));

        TextView textView = (TextView) findViewById(R.id.text_total_trans_price);
        textView.setText("Total Price: " + myCart.getTotalPrice());
        textView = (TextView) findViewById(R.id.text_total_trans_products);
        textView.setText("Number of Products: " + myCart.getCount());
    }

    private ShoppingCart myCart;
    private ProductTransition productTransition;
    private EmployeeTransition curEmployee;
}
