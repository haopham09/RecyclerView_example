package com.thohao.recyclerview_baitap;

import android.view.View;

public interface OnListener {
    boolean onItemLongClick(View v, int position);
    void onItemClick(View v,int position);
}
