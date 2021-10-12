package com.example.lab_a1_a2_android_dishant_c0812523.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProviderRepository {
    private ProviderDao providerDao;
    private LiveData<List<Provider>> listOfProviders;

    public ProviderRepository(Application application){
        AppDB appDB = AppDB.getInstance(application);
        providerDao = appDB.providerDao();
        listOfProviders = providerDao.getALlProviders();
    }

    public void insert(Provider provider){
        new ProviderRepository.InsertProviderAsyncTask(providerDao).execute(provider);
    }
    public void update(Provider provider){
        new ProviderRepository.UpdateProviderAsyncTask(providerDao).execute(provider);
    }
    public void delete(Provider provider){
        new ProviderRepository.DeleteProviderAsyncTask(providerDao).execute(provider);
    }

    public LiveData<List<Provider>> getListOfProviders() {
        return listOfProviders;
    }

    public static class InsertProviderAsyncTask extends AsyncTask<Provider,Void,Void> {

        private ProviderDao providerDao;

        private InsertProviderAsyncTask(ProviderDao providerDao){
            this.providerDao = providerDao;
        }

        @Override
        protected Void doInBackground(Provider... providers) {
            providerDao.insert(providers[0]);
            return null;
        }
    }

    public static class UpdateProviderAsyncTask extends AsyncTask<Provider,Void,Void>{

        private ProviderDao providerDao;

        private UpdateProviderAsyncTask(ProviderDao providerDao){
            this.providerDao = providerDao;
        }

        @Override
        protected Void doInBackground(Provider... providers) {
            providerDao.update(providers[0]);
            return null;
        }
    }

    public static class DeleteProviderAsyncTask extends AsyncTask<Provider,Void,Void>{

        private ProviderDao providerDao;

        private DeleteProviderAsyncTask(ProviderDao providerDao){
            this.providerDao = providerDao;
        }

        @Override
        protected Void doInBackground(Provider... providers) {
            providerDao.delete(providers[0]);
            return null;
        }
    }

}
