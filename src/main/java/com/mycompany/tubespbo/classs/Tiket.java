package com.mycompany.tubespbo.classs;

import com.mycompany.tubespbo.classs.SlotParkir;
import com.mycompany.tubespbo.classs.Kendaraan;
import com.mycompany.tubespbo.classs.Tarif;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Tiket {
    private String idTiket;
    private Kendaraan kendaraan;
    private SlotParkir slot;
    private LocalDateTime waktuMasuk;
    private LocalDateTime waktuKeluar;
    private double totalBiaya;

    public Tiket(String idTiket, Kendaraan kendaraan, SlotParkir slot, LocalDateTime waktuMasuk) {
        this.idTiket = idTiket;
        this.kendaraan = kendaraan;
        this.slot = slot;
        this.waktuMasuk = waktuMasuk;
    }

    public int hitungDurasi() {
        LocalDateTime keluar = (waktuKeluar != null) ? waktuKeluar : LocalDateTime.now();
        int jam = (int) ChronoUnit.HOURS.between(waktuMasuk, keluar);
        return jam < 1 ? 1 : jam;
    }

    public double hitungBiaya() {
        int durasi = hitungDurasi();
        if (kendaraan instanceof Tarif) {
            totalBiaya = ((Tarif) kendaraan).hitungTarif(durasi);
        }
        return totalBiaya;
    }

    public void cetakTiket() {
        System.out.println("====== TIKET PARKIR ======");
        System.out.println("ID Tiket  : " + idTiket);
        System.out.println("Kendaraan : " + kendaraan.getInfo());
        System.out.println("Slot      : " + slot.getIdSlot());
        System.out.println("Masuk     : " + waktuMasuk);
        System.out.println("Keluar    : " + (waktuKeluar != null ? waktuKeluar : "-"));
        System.out.println("Durasi    : " + hitungDurasi() + " jam");
        System.out.println("Total     : Rp " + hitungBiaya());
        System.out.println("==========================");
    }

    public String getIdTiket() { return idTiket; }
    public Kendaraan getKendaraan() { return kendaraan; }
    public SlotParkir getSlot() { return slot; }
    public LocalDateTime getWaktuMasuk() { return waktuMasuk; }
    public LocalDateTime getWaktuKeluar() { return waktuKeluar; }
    public double getTotalBiaya() { return totalBiaya; }
    public void setWaktuKeluar(LocalDateTime w) { this.waktuKeluar = w; }
    public void setTotalBiaya(double t) { this.totalBiaya = t; }
}