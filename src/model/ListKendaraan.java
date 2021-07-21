/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author fauzimalfath
 */
public class ListKendaraan {
    ArrayList<Kendaraan> kendaraan = new ArrayList<>();

    public void addKendaraan(Kendaraan k){
        kendaraan.add(k);
    }

    public ArrayList<Kendaraan> getKendaraan() {
        return kendaraan;
    }
    
    
}
