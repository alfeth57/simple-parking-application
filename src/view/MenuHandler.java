/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import model.MenuModel;

/**
 *
 * @author fauzimalfath
 */
public class MenuHandler implements ActionListener {

    private MenuModel model;
    private Menu view;
    
    public MenuHandler() {
        view = new Menu();
        model = new MenuModel(view.getTbData());
        view.setVisible(true);
        view.addActionListener(this);
        model.populate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         Object source = ae.getSource();
         try {
            
            if (source.equals(view.getSubmitMasuk())){
               model.masuk(view.getRb_2(), view.getNopolMasuk(), view.getJamMasuk(), view.getMenitMasuk());
               model.populate();
            } else if (source.equals(view.getCount())){
                //if (view.getJamKeluar()  view.getJamMasuk()){
                  //  JOptionPane.showMessageDialog(null, "Gagal Log", "Gagal Login", JOptionPane.ERROR_MESSAGE);
                //}else{
                    view.setHitung(model.hitung(view.getTbData(), view.getJamKeluar(), view.getMenitKeluar()));
                    model.populate();    
                
                
            }else if (source.equals(view.getCount())){
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
