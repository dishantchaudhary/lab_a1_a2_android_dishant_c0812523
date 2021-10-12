package com.example.lab_a1_a2_android_dishant_c0812523;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Provider;

import java.util.ArrayList;
import java.util.List;

public class ProviderAdapter  extends RecyclerView.Adapter<ProviderAdapter.ProviderHolder> {

    private List<Provider> providers = new ArrayList<>();
    private ProviderAdapter.OnItemClickListener listener;

    @NonNull
    @Override
    public ProviderAdapter.ProviderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.provider_item, parent, false);
        return new ProviderAdapter.ProviderHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderAdapter.ProviderHolder holder, int position) {
        Provider currentProvider = providers.get(position);
        holder.txvProviderName.setText("Name: " + currentProvider.getProviderName());
        holder.txvProviderEmail.setText("Price: " + currentProvider.getProviderEmail());
        holder.txvProviderPhone.setText("Provider: " + currentProvider.getProviderPhoneNo());
    }


    @Override
    public int getItemCount() {
        return providers.size();
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
        notifyDataSetChanged();
    }

    public Provider getProviderAt(int position) {
        return providers.get(position);
    }


    class ProviderHolder extends RecyclerView.ViewHolder {
        private TextView txvProviderName;
        private TextView txvProviderEmail;
        private TextView txvProviderPhone;
        private ImageView imgVEmail;
        private  ImageView imgVPhone;
        private ImageView imgVMap;

        public ProviderHolder(@NonNull View itemView) {
            super(itemView);
            txvProviderName = itemView.findViewById(R.id.txvProviderName);
            txvProviderEmail = itemView.findViewById(R.id.txvProviderEmail);
            txvProviderPhone = itemView.findViewById(R.id.txvProviderPhone);
            imgVEmail = itemView.findViewById(R.id.imgVEmail);
            imgVPhone = itemView.findViewById(R.id.imgVPhone);
            imgVMap = itemView.findViewById(R.id.imgVMap);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(providers.get(position));
                    }
                }
            });

            imgVEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onimgVEMail(providers.get(position));
                    }
                }
            });

            imgVPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onimgVPhone(providers.get(position));
                    }
                }
            });

            imgVMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onimgVMap(providers.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Provider provider);
        void onimgVEMail(Provider provider);
        void onimgVPhone(Provider provider);
        void onimgVMap(Provider provider);
    }

    public void setOnItemClickListener(ProviderAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

}