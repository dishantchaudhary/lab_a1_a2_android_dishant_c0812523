package com.example.lab_a1_a2_android_dishant_c0812523;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_a1_a2_android_dishant_c0812523.db.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> products = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.txvProductName.setText("Name: " + currentProduct.getProductName());
        holder.txvProductPrice.setText("Price: " + currentProduct.getProductPrice());
        holder.txvProductDescription.setText("Description: " + currentProduct.getProductDescription());
        holder.txvProductProvider.setText("Provider: " + currentProduct.getProductProvider());
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public Product getProductAt(int position) {
        return products.get(position);
    }


    class ProductHolder extends RecyclerView.ViewHolder {
        private TextView txvProductName;
        private TextView txvProductPrice;
        private TextView txvProductDescription;
        private TextView txvProductProvider;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            txvProductName = itemView.findViewById(R.id.txvProviderName);
            txvProductPrice = itemView.findViewById(R.id.txvProviderEmail);
            txvProductDescription = itemView.findViewById(R.id.txvProductDescription);
            txvProductProvider = itemView.findViewById(R.id.txvProviderPhone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(products.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}