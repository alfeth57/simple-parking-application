/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.Database;

/**
 *
 * @author fauzimalfath
 */
public class MenuModel {

    DefaultTableModel model;
    Database db;

    public MenuModel(JTable tbData) {
        model = (DefaultTableModel) tbData.getModel();
        db = new Database();
        db.connect();
        populate();
    }

    public void populate() {
        ListKendaraan lk = new ListKendaraan();
        lk = db.loadKendaraan();
        model.setRowCount(0);
        for (int i = 0; i < lk.getKendaraan().size(); i++) {
            if (lk.getKendaraan().get(i) instanceof RodaDua) {
                model.insertRow(model.getRowCount(), new Object[]{lk.getKendaraan().get(i).getNopol(), "Roda 2", lk.getKendaraan().get(i).getJammasuk(), lk.getKendaraan().get(i).getMenitmasuk()});
            } else {
                model.insertRow(model.getRowCount(), new Object[]{lk.getKendaraan().get(i).getNopol(), "Roda 4", lk.getKendaraan().get(i).getJammasuk(), lk.getKendaraan().get(i).getMenitmasuk()});
            }
        }
    }

    public void masuk(JRadioButton rb_2, String nopol, String jamMasuk, String menitMasuk) {
        Kendaraan k;
        if (rb_2.isSelected()) {
            model.insertRow(model.getRowCount(), new Object[]{nopol, "Roda 2", jamMasuk, menitMasuk});
            k = new RodaDua(nopol, Integer.parseInt(jamMasuk), Integer.parseInt(menitMasuk), 0, 0);
        } else {
            model.insertRow(model.getRowCount(), new Object[]{nopol, "Roda 4", jamMasuk, menitMasuk});
            k = new RodaEmpat(nopol, Integer.parseInt(jamMasuk), Integer.parseInt(menitMasuk), 0, 0);
        }
        db.saveKendaraan(k);
    }

    public String hitung(JTable tbData, String jamKeluar, String menitKeluar) {
        if (tbData.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Belum ada tabel yang terpilih", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Database db = new Database();
            db.connect();
            Kendaraan k = db.loadKendaraan(tbData.getValueAt(tbData.getSelectedRow(), 0).toString());

            db.deleteKendaraan(tbData.getValueAt(tbData.getSelectedRow(), 0).toString());

            k.setJamkeluar(Integer.parseInt(jamKeluar));
            k.setMenitkeluar(Integer.parseInt(menitKeluar));
            Transaksi t = new Transaksi(k);
            return t.toString();
        }
        return null;
    }
    

}
