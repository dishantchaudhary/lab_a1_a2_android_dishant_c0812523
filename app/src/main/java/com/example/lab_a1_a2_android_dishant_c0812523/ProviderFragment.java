package com.example.lab_a1_a2_android_dishant_c0812523;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Provider;
import com.example.lab_a1_a2_android_dishant_c0812523.viewModel.ProviderViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProviderFragment extends Fragment {

    private ProviderViewModel providerViewModel;

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.providerfragment_layout,container,false);

        recyclerView = view.findViewById(R.id.rvProvider);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        ProviderAdapter adapter = new ProviderAdapter();
        recyclerView.setAdapter(adapter);

        providerViewModel = new ViewModelProvider(getActivity()).get(ProviderViewModel.class);
        //productViewModel.insert(new Product("dishant","asjkdgbsdjgbad",13.0,"abc"))
//        providerViewModel.insert(new Provider("nestle","nestle@gmail.com","+1233456",34.0,-151.0));
//        providerViewModel.insert(new Provider("dcinc","dcinc12@gmail.com","+123898756",38.0,-159.0));
//        providerViewModel.insert(new Provider("tim","timc@gmail.com","+1225456",74.0,-251.0));
//        providerViewModel.insert(new Provider("starbuck","sb445@gmail.com","+9883456",94.0,-188.0));

        providerViewModel.getListOfProviders().observe(getActivity(), providers -> {

            //update view
            //listOfProducts = products;
            adapter.setProviders(providers);
        });

        adapter.setOnItemClickListener(new ProviderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Provider provider) {
                //Implement on click function
            }

            @Override
            public void onimgVEMail(Provider provider) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, provider.getProviderEmail());
                Intent mailer = Intent.createChooser(intent, null);
                startActivity(mailer);
            }

            @Override
            public void onimgVPhone(Provider provider) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", provider.getProviderPhoneNo(), null));
                startActivity(intent);
            }

            @Override
            public void onimgVMap(Provider provider) {

                Uri gmmIntentUri = Uri.parse("geo:"+provider.getProviderLatitude()+","+provider.getProiderLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);

            }
        });
        FloatingActionButton fab = view.findViewById(R.id.fabAddProvider);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EditProviderActivity.class);
                intent.putExtra("TYPE","ADD");
                startActivity(intent);
            }
        });
        return view;
    }
}
