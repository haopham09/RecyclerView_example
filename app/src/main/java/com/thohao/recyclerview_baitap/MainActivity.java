package com.thohao.recyclerview_baitap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView_freeship,recyclerView_khuyenmai;
    SanphamAdapter sanphamAdapter;
    ArrayList<Sanpham> sanphamArrayList;
    AlertDialog.Builder builder;
    String[] arrayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //slider image
        ViewPager viewPager=findViewById(R.id.viewpaper);
        ImageSliderApdater imageSliderApdater=new ImageSliderApdater(this);
        viewPager.setAdapter(imageSliderApdater);

        //recyclerview
        recyclerView_freeship=findViewById(R.id.recyclerView_freeship);
        recyclerView_khuyenmai=findViewById(R.id.recyclerView_khuyenmai);
        builder=new AlertDialog.Builder(MainActivity.this);
        sanphamArrayList=new ArrayList<>();
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.hanuri));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.buzza_pizza));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.morio));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.san_fu_lou));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.sushi));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.monkey_blackcoffee));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.buzza_pizza));
        sanphamArrayList.add(new Sanpham("Hanuri - San pham 1","22 Hai Ba Trung, Q1 ,HCM",R.drawable.morio));

        sanphamAdapter=new SanphamAdapter(sanphamArrayList);
        recyclerView_freeship.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, true));
        recyclerView_freeship.setAdapter(sanphamAdapter);
        ((SanphamAdapter)recyclerView_freeship.getAdapter()).setOnItemListener(new OnListener() {
            @Override
            public boolean onItemLongClick(View v, final int position) {
                arrayName=sanphamArrayList.get(position).getTensp().split(" - ");

                builder.setTitle("Bạn có muốn xóa ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sanphamArrayList.remove(position);
                        sanphamAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,sanphamArrayList.size()+"",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }

            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this,position + "", Toast.LENGTH_SHORT).show();

            }
        });

        recyclerView_khuyenmai.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, true));
        recyclerView_khuyenmai.setAdapter(sanphamAdapter);
        ((SanphamAdapter)recyclerView_khuyenmai.getAdapter()).setOnItemListener(new OnListener() {
            @Override
            public boolean onItemLongClick(View v, final int position) {
                arrayName=sanphamArrayList.get(position).getTensp().split(" - ");

                builder.setTitle("Bạn có muốn xóa ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sanphamArrayList.remove(position);
                        sanphamAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,sanphamArrayList.size()+"",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }

            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this,position + "", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
