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
public class Petugas {
    private String username;
    private String password;
    private String nama;
    private String alamat;

    public Petugas(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    

    public Petugas(String username, String password, String nama, String alamat) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
    
    
}
