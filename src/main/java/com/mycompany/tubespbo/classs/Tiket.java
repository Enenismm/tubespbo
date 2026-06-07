package com.mycompany.tubespbo.classs;

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
    
     public String getTiketString() {
        return "====== TIKET PARKIR ======\n" +
               "ID Tiket  : " + idTiket + "\n" +
               "Kendaraan : " + kendaraan.getInfo() + "\n" +
               "Slot      : " + slot.getIdSlot() + "\n" +
               "Masuk     : " + waktuMasuk + "\n" +
               "Keluar    : " + (waktuKeluar != null ? waktuKeluar : "-") + "\n" +
               "Durasi    : " + hitungDurasi() + " jam\n" +
               "Total     : Rp " + hitungBiaya() + "\n" +
               "==========================";
    }

    public String getIdTiket() { 
        return idTiket; }
    public Kendaraan getKendaraan() { 
        return kendaraan; }
    public SlotParkir getSlot() { 
        return slot; }
    public LocalDateTime getWaktuMasuk() { 
        return waktuMasuk; }
    public LocalDateTime getWaktuKeluar() { 
        return waktuKeluar; }
    public double getTotalBiaya() { 
        return totalBiaya; }
    public void setWaktuKeluar(LocalDateTime w) { 
        this.waktuKeluar = w; }
    public void setTotalBiaya(double t) { 
        this.totalBiaya = t; }
}