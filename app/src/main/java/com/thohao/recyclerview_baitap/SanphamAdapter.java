package com.thohao.recyclerview_baitap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.SanphamViewHolder> {
    private ArrayList<Sanpham>sanphamArrayList;
    private OnListener onListener;

    public SanphamAdapter(ArrayList<Sanpham> sanphamArrayList) {
        this.sanphamArrayList = sanphamArrayList;
    }
    public void setOnItemListener(OnListener onItemListener){
        this.onListener=onItemListener;
    }

    @NonNull
    @Override
    public SanphamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_layout_sanpham01,null);
        return new SanphamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanphamViewHolder holder, final int position) {
        Sanpham sanpham=sanphamArrayList.get(position);
        holder.img.setImageResource(sanpham.getHinhanh());
        holder.txtTensp.setText(sanpham.getTensp());
        holder.txtMota.setText(sanpham.getMota());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onListener.onItemLongClick(v, position);
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return sanphamArrayList !=null ?sanphamArrayList.size() : 0;
    }

    class SanphamViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtTensp, txtMota;

        public SanphamViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgSanpham);
            txtTensp=itemView.findViewById(R.id.txt_tensp);
            txtMota=itemView.findViewById(R.id.txt_mota);
        }
    }
}
