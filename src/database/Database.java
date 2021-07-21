/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author fauzimalfath
 */

import model.RodaDua;
import model.Kendaraan;
import model.ListKendaraan;
import model.RodaEmpat;
import model.Petugas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private String server = "jdbc:mysql://localhost:3306/pbo";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }
    
    public void savePetugas(Petugas p) {
        try {
            String query = "insert into account(username,password, nama, alamat) values"
                    + "('" + p.getUsername() + "', "
                    + "'" + p.getPassword() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("username/password salah");
        }
    }
    
    public void saveKendaraan(Kendaraan k) {
        try {
            String jenis;
            if (k instanceof RodaDua){
                jenis = "roda2";
            } else {
                jenis = "roda4";
            } 
            System.out.println(k.getMenitmasuk());
            String query = "insert into kendaraan(nopol, jenis, jammasuk, menitmasuk, jamkeluar,menitkeluar) values"
                    + "('" + k.getNopol() + "', "
                    + "'" + jenis + "',"
                    + "'" + k.getJammasuk() + "',"
                    + "'" + k.getMenitmasuk() + "',"
                    + "'" + k.getJamkeluar() + "',"
                    + "'" + k.getMenitkeluar() + "')";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("ada kesalahan saat menyimpan kendaraan");
        }
    }
    
    public void kendaraanKeluar(Kendaraan k){ // digunakan untuk penarikan dan setoran uang
        try {
            String query = "update tabungan set jamkeluar = '" + k.getJamkeluar() +"' , menitkeluar='"+k.getMenitkeluar()  + "' where nopol='" + k.getNopol() + "'";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("terjadi kesalahan saat setor uang");
        }
    }
    
    public Kendaraan loadKendaraan(String nopol){
        try {
            System.out.println(nopol);
            String query = "select * from kendaraan where nopol='" + nopol + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String jenis = rs.getString(2);
                Kendaraan k;
                if (jenis.equals("roda2")){
                    k = new RodaDua(rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                    
                    return k;
                } else {
                    k = new RodaEmpat(rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                    return k;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("terjadi kesalahan saat load kendaraan");
        }
    }
    
    public ListKendaraan loadKendaraan(){
        try {
            ListKendaraan lk = new ListKendaraan();
            String query = "select * from kendaraan";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Kendaraan k;
                String jenis = rs.getString(2);
                if (jenis.equals("roda2")){
                    k = new RodaDua(rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                    System.out.println("Load" + k.getMenitmasuk());
                } else {
                    k = new RodaEmpat(rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                }
                lk.addKendaraan(k);
            }
            return lk;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("terjadi kesalahan saat load kendaraan");
        }
    }
    
    public void deleteKendaraan(String nopol){
        try {
            String query = "delete from kendaraan where nopol='" + nopol+"'";
            statement.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("terjadi kesalahan saat delete");
        }
    }
    public boolean login(Petugas p){
        try {
            String query = "select * from account where username ='" + p.getUsername() + "' and password = '" +p.getPassword() + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("terjadi kesalahan saat login");
        }
    }
    
    

}
