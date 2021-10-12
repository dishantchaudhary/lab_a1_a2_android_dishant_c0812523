package com.example.lab_a1_a2_android_dishant_c0812523;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Product;
import com.example.lab_a1_a2_android_dishant_c0812523.db.Provider;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProductViewModel;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProviderViewModel;

import java.util.List;

public class EditProductActivity extends AppCompatActivity {

    EditText edtProductName, edtProductPrice, edtProductDescription;
    Spinner spProductProvider;
    Button btnSave,btnProductDelete;

    private ProductViewModel productViewModel;
    private ProviderViewModel providerViewModel;

    public static String providerOfProduct = "None";
    public static int productID = -1;
    List<Provider> listOfProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        edtProductName = findViewById(R.id.edtProductName);
        edtProductDescription = findViewById(R.id.edtDescription);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        spProductProvider = findViewById(R.id.spProductProvider);
        btnSave = findViewById(R.id.btnProductSave);
        btnProductDelete = findViewById(R.id.btnProductDelete);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        providerViewModel = new ViewModelProvider(this).get(ProviderViewModel.class);
        //providerViewModel.insert(new Provider("abc","dishant@gmail.com","+1132415",-35.0,152.0));
        providerViewModel.getListOfProviders().observe(this,providers -> {
            listOfProviders = providers;
            fillProvider();
        });

        Bundle extras = getIntent().getExtras();
        if(extras.getString("TYPE").equals("ADD")){
            btnProductDelete.setVisibility(View.GONE);
            providerOfProduct = "None";
        }else{
            productID = Integer.parseInt(extras.getString("ID"));
            edtProductName.setText(extras.getString("NAME"));
            edtProductPrice.setText(extras.getString("PRICE"));
            edtProductDescription.setText(extras.getString("DESCRIPTION"));
            providerOfProduct =  extras.getString("PROVIDER");
        }

        //Save Button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtProductName.getText().toString();
                String description = edtProductDescription.getText().toString();
                String price = edtProductPrice.getText().toString();
                String provider = providerOfProduct;
                if (name.trim().isEmpty() || description.trim().isEmpty() || price.trim().isEmpty() || providerOfProduct == "None") {
                    Toast.makeText(EditProductActivity.this, "Please provide the complete details.", Toast.LENGTH_SHORT).show();
                }else{
                    Product product = new Product(name,description,Double.parseDouble(price),provider);
                    if(productID == -1){
                        productViewModel.insert(product);
                    }else{
                        product.setProductId(productID);
                        productViewModel.update(product);
                    }
                    finish();
                }
            }
        });

        btnProductDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtProductName.getText().toString();
                String description = edtProductDescription.getText().toString();
                String price = edtProductPrice.getText().toString();
                String provider = providerOfProduct;
                if (name.trim().isEmpty() || description.trim().isEmpty() || price.trim().isEmpty() || providerOfProduct == "None") {
                    Toast.makeText(EditProductActivity.this, "Please provide the complete details.", Toast.LENGTH_SHORT).show();
                }else{
                    Product product = new Product(name,description,Double.parseDouble(price),provider);
                    product.setProductId(productID);
                    productViewModel.delete(product);
                    finish();
                }
            }
        });
    }
    public void fillProvider(){
        String[] nameOfProviders = new String[listOfProviders.size()+1];
        nameOfProviders[0] = "None";
        for(int i = 1; i<=listOfProviders.size();i++){
            nameOfProviders[i] = listOfProviders.get(i-1).getProviderName();
        }

        //Creating the ArrayAdapter instance having the providers
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,nameOfProviders);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProductProvider.setAdapter(aa);
        int spinnerPosition = aa.getPosition(providerOfProduct);
        spProductProvider.setSelection(spinnerPosition);

        spProductProvider.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                providerOfProduct = nameOfProviders[i];
                //Toast.makeText(EditProductActivity.this, "Providers: "+nameOfProviders[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}