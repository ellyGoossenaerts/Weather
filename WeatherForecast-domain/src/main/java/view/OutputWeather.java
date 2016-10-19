/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class OutputWeather extends JFrame {
    
    private JPanel outputPanel = new JPanel();
    private JLabel location;
    private JLabel date;
    private JLabel maxTemp;
    private JLabel minTemp;
    private JLabel description;
    private JLabel date1;
    private JLabel maxTemp1;
    private JLabel minTemp1;
    private JLabel description1;
    private JLabel date2;
    private JLabel maxTemp2;
    private JLabel minTemp2;
    private JLabel description2;
    private JLabel date3;
    private JLabel maxTemp3;
    private JLabel minTemp3;
    private JLabel description3;
    private JLabel date4;
    private JLabel maxTemp4;
    private JLabel minTemp4;
    private JLabel description4;
    private Controller c;
    private BufferedImage icon;
    private BufferedImage icon1;
    private BufferedImage icon2;
    private BufferedImage icon3;
    private BufferedImage icon4;
    public OutputWeather(final Controller c) throws Exception{
        this.c = c;
        GridBagLayout layout = new GridBagLayout();
        outputPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;  
	gbc.gridy = 0;
        location = new JLabel(c.getCity());
        outputPanel.add(location,gbc);
        gbc.gridx = 0;
	gbc.gridy = 1;
        icon = ImageIO.read(new URL(c.getForecast().get(0).getIcon()));
        JLabel wIcon = new JLabel(new ImageIcon(icon));
        outputPanel.add(wIcon,gbc);
        gbc.gridx = 0;
	gbc.gridy = 2;
        date = new JLabel("Date: "+c.getForecast().get(0).getForecastDate());
        outputPanel.add(date,gbc);
        gbc.gridx = 0;
	gbc.gridy = 3;
        maxTemp = new JLabel("MAX: "+c.getForecast().get(0).getMaximumTemperature() + "°C");
        outputPanel.add(maxTemp,gbc);
        gbc.gridx = 0;
	gbc.gridy = 4;
        minTemp = new JLabel("MIN: "+ c.getForecast().get(0).getMinimumTemperature() + "°C");
        outputPanel.add(minTemp,gbc);
        gbc.gridx = 0;
	gbc.gridy = 5;
        description = new JLabel(c.getForecast().get(0).getDescription());
        outputPanel.add(description,gbc);
        gbc.gridx = 1;
	gbc.gridy = 1;
        icon1 = ImageIO.read(new URL(c.getForecast().get(1).getIcon()));
        JLabel wIcon1 = new JLabel(new ImageIcon(icon1));
        outputPanel.add(wIcon1,gbc);
        gbc.gridx = 1;
	gbc.gridy = 2;
        date1 = new JLabel("Date: "+c.getForecast().get(1).getForecastDate());
        outputPanel.add(date1,gbc);
        gbc.gridx = 1;
	gbc.gridy = 3;
        maxTemp1 = new JLabel("MAX: "+c.getForecast().get(1).getMaximumTemperature() + "°C");
        outputPanel.add(maxTemp1,gbc);
        gbc.gridx = 1;
	gbc.gridy = 4;
        minTemp1 = new JLabel("MIN: "+ c.getForecast().get(1).getMinimumTemperature() + "°C");
        outputPanel.add(minTemp1,gbc);
        gbc.gridx = 1;
	gbc.gridy = 5;
        description1 = new JLabel(c.getForecast().get(1).getDescription());
        outputPanel.add(description1,gbc);
        gbc.gridx = 2;
	gbc.gridy = 1;
        icon2 = ImageIO.read(new URL(c.getForecast().get(2).getIcon()));
        JLabel wIcon2 = new JLabel(new ImageIcon(icon2));
        outputPanel.add(wIcon2,gbc);
        gbc.gridx = 2;
	gbc.gridy = 2;
        date2 = new JLabel("Date: "+c.getForecast().get(2).getForecastDate());
        outputPanel.add(date2,gbc);
        gbc.gridx = 2;
	gbc.gridy = 3;
        maxTemp2 = new JLabel("MAX: "+c.getForecast().get(2).getMaximumTemperature() + "°C");
        outputPanel.add(maxTemp2,gbc);
        gbc.gridx = 2;
	gbc.gridy = 4;
        minTemp2 = new JLabel("MIN: "+ c.getForecast().get(2).getMinimumTemperature() + "°C");
        outputPanel.add(minTemp2,gbc);
        gbc.gridx = 2;
	gbc.gridy = 5;
        description2 = new JLabel(c.getForecast().get(2).getDescription());
        outputPanel.add(description2,gbc);
      
        
        this.setContentPane(outputPanel);
        this.setTitle("Weather");
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
	this.setVisible(true);
        
        
    }
    
    
}
