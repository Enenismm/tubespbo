package com.mycompany.tubespbo.classs;

public class SlotParkir {
    private String idSlot;
    private boolean status;
    private String jenisSlot;

    public SlotParkir(String idSlot, boolean status, String jenisSlot) {
        this.idSlot = idSlot;
        this.status = status;
        this.jenisSlot = jenisSlot;
    }

    public boolean ketersediaan() { return !status; }
    public void setStatus(boolean s) { this.status = s; }
    public String getIdSlot() { return idSlot; }
    public String getJenisSlot() { return jenisSlot; }
}