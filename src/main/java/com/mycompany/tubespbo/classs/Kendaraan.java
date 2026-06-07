package com.mycompany.tubespbo.classs;

public abstract class Kendaraan {
    private String platNomor;
    private String merk;
    private int jumlahRoda;

    public Kendaraan(String platNomor, String merk, int jumlahRoda) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.jumlahRoda = jumlahRoda;
    }

    public String getPlatNomor() { return platNomor; }
    public String getMerk() { return merk; }
    public int getJumlahRoda() { return jumlahRoda; }
    public abstract String getInfo();
}