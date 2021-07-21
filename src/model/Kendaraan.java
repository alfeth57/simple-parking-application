/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fauzimalfath
 */
public class Kendaraan {
    private String nopol;
    private int jammasuk;
    private int menitmasuk;
    private int jamkeluar;
    private int menitkeluar;

    public Kendaraan(String nopol, int jammasuk, int menitmasuk, int jamkeluar, int menitkeluar) {
        this.nopol = nopol;
        this.jammasuk = jammasuk;
        this.menitmasuk = menitmasuk;
        this.jamkeluar = jamkeluar;
        this.menitkeluar = menitkeluar;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public int getJammasuk() {
        return jammasuk;
    }

    public void setJammasuk(int jammasuk) {
        this.jammasuk = jammasuk;
    }

    public int getMenitmasuk() {
        return menitmasuk;
    }

    public void setMenitmasuk(int menitmasuk) {
        this.menitmasuk = menitmasuk;
    }

    public int getJamkeluar() {
        return jamkeluar;
    }

    public void setJamkeluar(int jamkeluar) {
        this.jamkeluar = jamkeluar;
    }

    public int getMenitkeluar() {
        return menitkeluar;
    }

    public void setMenitkeluar(int menitkeluar) {
        this.menitkeluar = menitkeluar;
    }
    
    
    
}
