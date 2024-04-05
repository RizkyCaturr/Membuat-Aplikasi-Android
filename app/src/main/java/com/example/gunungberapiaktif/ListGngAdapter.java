package com.example.gunungberapiaktif;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListGngAdapter extends RecyclerView.Adapter<ListGngAdapter.ListViewHolder> {

    private ArrayList<GunungBerapi> listGunungBerapi;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListGngAdapter(ArrayList<GunungBerapi> list) {
        this.listGunungBerapi = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gunungberapi, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        GunungBerapi gng = listGunungBerapi.get(position);
        Glide.with(holder.itemView.getContext())
                .load(gng.getPhoto())
                .apply(new RequestOptions().override(88, 80))
                .into(holder.imgPhoto);
        holder.tvNama.setText(gng.getName());
        holder.tvTinggi.setText(gng.getTinggi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listGunungBerapi.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGunungBerapi.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama, tvTinggi;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvTinggi = itemView.findViewById(R.id.tv_item_tinggi);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(GunungBerapi data);
    }
}