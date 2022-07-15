package com.example.doan_game;

public class DanhSach {
    private int Id;
    private String Ten;
    private String Diem;

    public DanhSach(int id, String ten, String diem) {
        Id = id;
        Ten = ten;
        Diem = diem;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiem() {
        return Diem;
    }

    public void setDiem(String diem) {
        Diem = diem;
    }
}
