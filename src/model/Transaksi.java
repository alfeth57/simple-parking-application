/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author fauzimalfath
 */
public class Transaksi { 
  Kendaraan k;

    public Transaksi(Kendaraan k) {
        this.k = k;
    }
    
    public double getLamaParkir(){
        return  ((k.getJamkeluar() * 60) + k.getMenitkeluar()) - ((k.getJammasuk() * 60) + k.getMenitmasuk()) ;  
    }
    
    double getJam(Kendaraan k){
        double lamaParkirJam = k.getJamkeluar() - k.getJammasuk();
        double lamaParkirMenit = k.getMenitkeluar() - k.getMenitmasuk();
        
        if (lamaParkirMenit > 0){
            lamaParkirJam = lamaParkirJam + 1;
        }
        return lamaParkirJam;
    }
    public String toString(){
        String s = "";
        if (k.getJamkeluar()<k.getJammasuk()){
            s = "[ERROR]"+
                "\nJam keluar / Menit keluar tidak dapat terdefinisi di sistem";
        }
        else if((k.getJamkeluar()==k.getJammasuk()) && (k.getMenitkeluar()<=k.getMenitmasuk())){
            s = "[ERROR]"+
                "\nJam keluar / Menit keluar tidak dapat terdefinisi di sistem";
        }
        else if (k instanceof RodaDua){
            s = "No Polisi: " + k.getNopol() +
                    "\nJam Masuk: " + k.getJammasuk() + ":" +k.getMenitmasuk() +
                    "\nJam Keluar: " + k.getJamkeluar() + ":" + k.getMenitkeluar()+
                    "\nLama Parkir:" + getLamaParkir() + "menit" +
                    "\nTotal Harga: " + getJam(k) * 2000 ;

        } else {
            s = "No Polisi: " + k.getNopol() +
                    "\nJam Masuk: " + k.getJammasuk() + ":" +k.getMenitmasuk() +
                    "\nJam Keluar: " + k.getJamkeluar() + ":" + k.getMenitkeluar()+
                    "\nLama Parkir:" + getLamaParkir() + "menit" +
                    "\nTotal Harga: " + getJam(k)* 3000 ;
        }
        return  s;
    }
    
}

