/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import view.Menu;

/**
 *
 * @author fauzimalfath
 */
public class LoginModel {
    Database db;

    public LoginModel() {
        db = new Database();
        db.connect();
    }
    
    
    public boolean login(String username, String password){
        Petugas p = new Petugas(username, password);
        if (db.login(p)){
            return true;
        } else {
            return false;
        }
    }
}
