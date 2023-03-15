/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aula1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author egodjoe
 */
public class UI implements ActionListener {
    
    private JLabel label = new JLabel("Movement Directions     ");
    private JFrame frame = new JFrame();
    
    JButton buttonN = new JButton();
    JButton buttonE = new JButton();
    JButton buttonS = new JButton();
    JButton buttonW = new JButton();
    JButton stopButton = new JButton();

    private double[] moveDirection = new double[2];
    private boolean canStep = false;
    
    public UI() {

        // the clickable button
        
        buttonN.setBounds(50,100,50,50);
        buttonN.addActionListener(this);
        buttonN.setText("North");
        
        buttonE.setBounds(100,50,50,50);
        buttonE.addActionListener(this);
        buttonE.setText("East");
       
           
        buttonS.setBounds(50,0,50,50);
        buttonS.addActionListener(this);
        buttonS.setText("South");
       
        
        buttonW.setBounds(0,50,50,50);
        buttonW.addActionListener(this);
        buttonW.setText("West");

        stopButton.setBounds(0,50,50,50);
        stopButton.addActionListener(this);
        stopButton.setText("Stop Moving");
        
        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(buttonN);
        panel.add(buttonE);
        panel.add(buttonS);
        panel.add(buttonW);
        panel.add(stopButton);
        panel.add(label);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UI for creature control");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==buttonN){
            this.moveDirection[0] = 0;
            this.moveDirection[1] = -10000;
            this.canStep = true;
            
        }
        
        else if(e.getSource() == buttonE){
            moveDirection[0] = 10000;
            moveDirection[1] = 0;
            this.canStep = true;
            
        }
         else if(e.getSource() == buttonS){
            moveDirection[0] = 0;
            moveDirection[1] = 10000;
            this.canStep = true;
          
        }
         else if(e.getSource() == buttonW){
            moveDirection[0] = -10000;
            moveDirection[1] = 0;
            this.canStep = true;
            
        }
        
         else if(e.getSource()==stopButton){
             this.canStep = false;
            
         }
        
        
    }
    
    public boolean checkCanStep(){
        return this.canStep;
    }
    
    public double[] getMovementDirections(){
        return this.moveDirection;
    }
}
