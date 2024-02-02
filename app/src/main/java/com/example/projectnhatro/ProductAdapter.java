package com.example.projectnhatro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectnhatro.fragments.HomeFragment;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mContext;
    private List<Product> List_Product;

    public ProductAdapter(HomeFragment mContext) {
        this.mContext = mContext.requireContext();
    }

    public void setData(List<Product> list){
        this.List_Product = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
Product product = List_Product.get(position);
if (product == null){
    return;
}
holder.imgProduct.setImageResource(product.getResourceImage());
holder.textView_Product.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        if (List_Product != null)
        {
        return List_Product.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        // khai báo thành phần có trong item_product

        private ImageView imgProduct;

        private TextView textView_Product;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.img_product);

            textView_Product = itemView.findViewById(R.id.textView_Product);
        }
    }
}
