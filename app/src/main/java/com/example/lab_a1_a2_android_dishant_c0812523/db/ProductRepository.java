package com.example.lab_a1_a2_android_dishant_c0812523.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> listOfProducts;

    public ProductRepository(Application application){
        AppDB appDB = AppDB.getInstance(application);
        productDao = appDB.productDao();
        listOfProducts = productDao.getAllProducts();
    }

    public void insert(Product product){
        new InsertProductAsyncTask(productDao).execute(product);
    }
    public void update(Product product){
        new UpdateProductAsyncTask(productDao).execute(product);
    }
    public void delete(Product product){
        new DeleteProductAsyncTask(productDao).execute(product);
    }

    public LiveData<List<Product>> getListOfProducts() {
        return listOfProducts;
    }

    public static class InsertProductAsyncTask extends AsyncTask<Product,Void,Void> {

        private ProductDao productDao;

        private InsertProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }
    }

    public static class UpdateProductAsyncTask extends AsyncTask<Product,Void,Void>{

        private ProductDao productDao;

        private UpdateProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.update(products[0]);
            return null;
        }
    }

    public static class DeleteProductAsyncTask extends AsyncTask<Product,Void,Void>{

        private ProductDao productDao;

        private DeleteProductAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }
    }

}
