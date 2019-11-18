package com.thohao.recyclerview_baitap;

public class Sanpham {
    private String tensp;
    private String mota;
    private int hinhanh;

    public Sanpham() {
    }

    public Sanpham(String tensp, String mota, int hinhanh) {
        this.tensp = tensp;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
