package com.project.models;

public class Thongbao {
    private String Tenthongbao;
    private String Mathongbao;
    private String Motathongbao;
    private String Thoigianthongbao;
    private String Ngaythongbao;
    private int Hinhthongbao;

    public Thongbao(String tenthongbao, String mathongbao, String motathongbao, String thoigianthongbao, String ngaythongbao) {
        Tenthongbao = tenthongbao;
        Mathongbao = mathongbao;
        Motathongbao = motathongbao;
        Thoigianthongbao = thoigianthongbao;
        Ngaythongbao = ngaythongbao;
    }

    public String getTenthongbao() {
        return Tenthongbao;
    }

    public void setTenthongbao(String tenthongbao) {
        Tenthongbao = tenthongbao;
    }

    public String getMathongbao() {
        return Mathongbao;
    }

    public void setMathongbao(String mathongbao) {
        Mathongbao = mathongbao;
    }

    public String getMotathongbao() {
        return Motathongbao;
    }

    public void setMotathongbao(String motathongbao) {
        Motathongbao = motathongbao;
    }

    public String getThoigianthongbao() {
        return Thoigianthongbao;
    }

    public void setThoigianthongbao(String thoigianthongbao) {
        Thoigianthongbao = thoigianthongbao;
    }

    public String getNgaythongbao() {
        return Ngaythongbao;
    }

    public void setNgaythongbao(String ngaythongbao) {
        Ngaythongbao = ngaythongbao;
    }

    public int getHinhthongbao() {
        return Hinhthongbao;
    }

    public void setHinhthongbao(int hinhthongbao) {
        Hinhthongbao = hinhthongbao;
    }
}
