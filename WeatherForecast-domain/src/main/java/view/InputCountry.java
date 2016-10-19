/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.ucll.exam.weatherforecast.domain.Controller;

/**
 *
 * @author Eline
 */
public class InputCountry extends JFrame{
    
    private JPanel inputPanel = new JPanel();
    private JTextField input = new JTextField("Country",20);
    private JButton confirm = new JButton("next");
    private JLabel country = new JLabel("Please enter you're country (bv.BE): ");
    private Controller c;
    
    public InputCountry(final Controller c){
        this.c = c;
        GridBagLayout layout = new GridBagLayout();
        inputPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5,0,5,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;  
	gbc.gridy = 0;
        inputPanel.add(country,gbc);
        gbc.gridx = 0;
	gbc.gridy = 1;
        inputPanel.add(input,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
        inputPanel.add(confirm,gbc);
        confirm.setEnabled(true);
        
        
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                c.setCountry(input.getText());
                InputCity inputcity = new InputCity(c);
                System.out.println(c.getCountry());
            }
            
        };
        confirm.addActionListener(listener);
        this.setContentPane(inputPanel);
        this.setTitle("input country");
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
	this.setVisible(true);
        
        
    }
    
}
