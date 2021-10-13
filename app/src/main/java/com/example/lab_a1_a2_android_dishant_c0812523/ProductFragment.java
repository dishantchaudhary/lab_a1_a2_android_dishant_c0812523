package com.example.lab_a1_a2_android_dishant_c0812523;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Product;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProductViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    RecyclerView recyclerView;
    EditText edtSearch;
    Button btnSearch;
    public static List<Product> listOfProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.productfragment_layout,container,false);

        recyclerView = view.findViewById(R.id.rvProducts);
        btnSearch = view.findViewById(R.id.btnSearch);
        edtSearch = view.findViewById(R.id.edtSearchText);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        ProductAdapter adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

        productViewModel = new ViewModelProvider(getActivity()).get(ProductViewModel.class);

//        productViewModel.insert(new Product("coke","dietcoke",1.9,"nestle"));
//        productViewModel.insert(new Product("water","minral",1.1,"dcinc"));
//        productViewModel.insert(new Product("tea","chaitea",2.5,"tim"));
//        productViewModel.insert(new Product("coffee","dark",3.3,"starbuck"));

        productViewModel.getListOfProducts().observe(getActivity(), products -> {
            //update view
            listOfProducts = products;
            adapter.setProducts(products);
        });

        //Search
        btnSearch.setOnClickListener(v->{
            List<Product> sProduct = listOfProducts;
            List<Product> localProducts = new ArrayList<>();
            if(!edtSearch.getText().toString().trim().isEmpty()) {
                for (int i = 0; i < listOfProducts.size(); i++) {
                    if(sProduct.get(i).getProductName().toLowerCase().contains(edtSearch.getText().toString().toLowerCase()) ||
                    sProduct.get(i).getProductDescription().toLowerCase().contains(edtSearch.getText().toString().toLowerCase())){
                        localProducts.add(sProduct.get(i));
                    }
                }
                if(localProducts == null){
                    Toast.makeText(getActivity(), "No Product Found", Toast.LENGTH_SHORT).show();
                }else{
                    adapter.setProducts(localProducts);
                }
            }else{
                adapter.setProducts(sProduct);
            }
        });

        //Add a new Product
        FloatingActionButton fab = view.findViewById(R.id.fabAddProduct);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EditProductActivity.class);
                intent.putExtra("TYPE","ADD");
                startActivity(intent);
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Intent intent = new Intent(getActivity(), EditProductActivity.class);
                intent.putExtra("TYPE","EDIT");
                String id = String.valueOf(product.getProductId());
                intent.putExtra("ID",id);
                intent.putExtra("NAME",product.getProductName());
                String price = String.valueOf(product.getProductPrice());
                intent.putExtra("PRICE", price);
                intent.putExtra("DESCRIPTION",product.getProductDescription());
                intent.putExtra("PROVIDER",product.getProductProvider());
                startActivity(intent);
            }
        });
        return view;
    }
}
