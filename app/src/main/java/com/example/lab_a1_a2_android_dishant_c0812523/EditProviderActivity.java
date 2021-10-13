package com.example.lab_a1_a2_android_dishant_c0812523;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Product;
import com.example.lab_a1_a2_android_dishant_c0812523.db.Provider;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProductViewModel;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProviderViewModel;

import java.util.List;

public class EditProviderActivity extends AppCompatActivity {

    EditText edtPhone, edtEmail, edtName, edtLat, edtLong;
    Button btnSave, btnDelete;

    private ProductViewModel productViewModel;
    private ProviderViewModel providerViewModel;
    List<Product> listOfProducts;

    public static int providerID = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_provider);

        edtEmail = findViewById(R.id.edtProviderEmail);
        edtLong = findViewById(R.id.edtProviderLong);
        edtLat = findViewById(R.id.edtProviderLat);
        edtName = findViewById(R.id.edtProviderName);
        edtPhone = findViewById(R.id.edtProviderPhone);
        btnSave = findViewById(R.id.btnProviderSave);
        btnDelete = findViewById(R.id.btnProviderDelete);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        providerViewModel = new ViewModelProvider(this).get(ProviderViewModel.class);

        Bundle extras = getIntent().getExtras();
        if(extras.getString("TYPE").equals("ADD")){
            btnDelete.setVisibility(View.GONE);
            providerID = -1;
        }else{
            providerID = Integer.parseInt(extras.getString("ID"));
            edtName.setText(extras.getString("NAME"));
            edtEmail.setText(extras.getString("EMAIL"));
            edtLong.setText(extras.getString("LONGITUDE"));
            edtLat.setText(extras.getString("LATITUDE"));
            edtPhone.setText(extras.getString("PHONENO"));
        }

        productViewModel.getListOfProducts().observe(this, products -> {
            listOfProducts = products;
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String longitude = edtLong.getText().toString();
                String latitude = edtLat.getText().toString();
                String phone = edtPhone.getText().toString();
                if (name.trim().isEmpty() || email.trim().isEmpty() || longitude.trim().isEmpty() || latitude.trim().isEmpty()|| phone.trim().isEmpty()) {
                    Toast.makeText(EditProviderActivity.this, "Please provide the complete details.", Toast.LENGTH_SHORT).show();
                }else{
                    Provider provider = new Provider(name,email,phone,Double.parseDouble(latitude),Double.parseDouble(longitude));
                    if(providerID == -1){
                        providerViewModel.insert(provider);
                    }else{
                        provider.setProviderId(providerID);
                        providerViewModel.update(provider);
                    }
                    finish();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String longitude = edtLong.getText().toString();
                String latitude = edtLat.getText().toString();
                String phone = edtPhone.getText().toString();
                if (name.trim().isEmpty() || email.trim().isEmpty() || longitude.trim().isEmpty() || latitude.trim().isEmpty()|| phone.trim().isEmpty()) {
                    Toast.makeText(EditProviderActivity.this, "Please provide the complete details.", Toast.LENGTH_SHORT).show();
                }else{
                    Provider provider = new Provider(name,email,phone,Double.parseDouble(latitude),Double.parseDouble(longitude));
                    provider.setProviderId(providerID);
                    for(int i = 0; i< listOfProducts.size(); i++){
                        if(listOfProducts.get(i).getProductProvider().equals(provider.getProviderName())){
                            productViewModel.delete(listOfProducts.get(i));
                        }
                    }
                    providerViewModel.delete(provider);
                    finish();
                }
            }
        });
    }
}