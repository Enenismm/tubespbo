package com.mycompany.tubespbo.classs;

import com.mycompany.tubespbo.classs.Kendaraan;
import com.mycompany.tubespbo.classs.Tarif;

public class Mobil extends Kendaraan implements Tarif {

    public Mobil(String platNomor, String merk) {
        super(platNomor, merk, 4);
    }

    @Override
    public double hitungTarif(int jam) {
        return jam * 4000;
    }

    @Override
    public String getInfo() {
        return "Mobil | " + getPlatNomor() + " | " + getMerk();
    }
}