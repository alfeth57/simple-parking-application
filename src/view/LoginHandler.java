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


/**
 *
 * @author fauzimalfath
 */
public class LoginHandler implements ActionListener {

    private LoginModel model;
    private Login view;
    
    public LoginHandler() {
        model = new LoginModel();
        view = new Login();
        view.setVisible(true);
        view.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         Object source = ae.getSource();
         try {
            if (source.equals(view.getjButton1())){
                System.out.println(view.getTx_pass());
                if (model.login(view.getTx_id(), view.getTx_pass())){
                    new MenuHandler();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login", "Gagal Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}