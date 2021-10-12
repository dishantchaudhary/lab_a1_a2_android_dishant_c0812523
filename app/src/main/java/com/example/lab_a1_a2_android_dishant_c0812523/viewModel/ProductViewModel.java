package com.example.lab_a1_a2_android_dishant_c0812523.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Product;
import com.example.lab_a1_a2_android_dishant_c0812523.db.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;
    private LiveData<List<Product>> listOfProducts;


    public ProductViewModel(@NonNull Application application) {
        super(application);

        repository = new ProductRepository(application);
        listOfProducts = repository.getListOfProducts();
    }

    public void insert(Product product){
        repository.insert(product);
    }

    public void update(Product product){
        repository.update(product);
    }

    public void delete(Product product){
        repository.delete(product);
    }

    public LiveData<List<Product>> getListOfProducts() {
        return listOfProducts;
    }
}
