package com.example.lab_a1_a2_android_dishant_c0812523.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Provider;
import com.example.lab_a1_a2_android_dishant_c0812523.db.ProviderRepository;

import java.util.List;

public class ProviderViewModel  extends AndroidViewModel {
    private ProviderRepository repository;
    private LiveData<List<Provider>> listOfProviders;


    public ProviderViewModel(@NonNull Application application) {
        super(application);

        repository = new ProviderRepository(application);
        listOfProviders = repository.getListOfProviders();
    }

    public void insert(Provider provider){
        repository.insert(provider);
    }

    public void update(Provider provider){
        repository.update(provider);
    }

    public void delete(Provider provider){
        repository.delete(provider);
    }

    public LiveData<List<Provider>> getListOfProviders() {
        return listOfProviders;
    }
}
