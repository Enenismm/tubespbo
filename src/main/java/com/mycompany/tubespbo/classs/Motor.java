package com.mycompany.tubespbo.classs;

import com.mycompany.tubespbo.classs.Kendaraan;
import com.mycompany.tubespbo.classs.Tarif;

public class Motor extends Kendaraan implements Tarif {

    public Motor(String platNomor, String merk) {
        super(platNomor, merk, 2);
    }

    @Override
    public double hitungTarif(int jam) {
        return jam * 2000;
    }

    @Override
    public String getInfo() {
        return "Motor | " + getPlatNomor() + " | " + getMerk();
    }
}