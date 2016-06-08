/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Table;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

// test commentaire à supprimer

/**
 *
 * @author abdel
 */
public class Init {

    private static Init uniqueInstance;
    public XMLDecoder decoder = null;
    public XMLEncoder encoder = null;

    private Init() {
        encodXML();
        decodXML();
    }

    public static Init getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Init();
        }
        return uniqueInstance;

    }

    public void encodXML() {

        Visiteur villechalane = new Visiteur(1, "villechalane", "Louis");
        Visiteur Bedos = new Visiteur(2, "Bedos", "Charles");
        Visiteur Gallet= new Visiteur(3, "Gallet", "luc");
        Visiteur Chaise = new Visiteur(4, "Chaise", "Pere");
        Visiteur Dupont = new Visiteur(5, "Dupont", "alain");
        
        Vehicule vehicule1 = new Vehicule(1, "Mercedez", "Benz", 150000, "Haute gamme");
        Vehicule vehicule2 = new Vehicule(2, "Audi", "A6", 15005, "Haute gamme");
        Vehicule vehicule3 = new Vehicule(3, "BMW", "M3", 13000, "Moyenne gamme");
        Vehicule vehicule4 = new Vehicule(4, "Citroen", "C4", 10000, "Moyenne gamme");
        Vehicule vehicule5 = new Vehicule(5, "Peugeot", "307", 12810, "Moyenne gamme");
        Vehicule vehicule6 = new Vehicule(6, "Peugeot", "207", 11500, "Basse gamme");
        Vehicule vehicule7 = new Vehicule(7, "Renault", "Clio", 1500, "Basse gamme");
        
        Chaise.addVehicule(vehicule4);
        Chaise.addVehicule(vehicule2);
        Chaise.addVehicule(vehicule1);
        Bedos.addVehicule(vehicule1);
        Bedos.addVehicule(vehicule2);
        villechalane.addVehicule(vehicule6);
        villechalane.addVehicule(vehicule5);
        Dupont.addVehicule(vehicule3);
        Dupont.addVehicule(vehicule2);
        
                try {
            encoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream("utilisateur.xml")));

            encoder.writeObject(Chaise.getLPersonnes());
            encoder.writeObject(Bedos.getLPersonnes());
            encoder.writeObject(villechalane.getLPersonnes());;
            encoder.flush();

        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            if (encoder != null) {
                encoder.close();
            }
        }

    }

    public void decodXML() {

        XMLDecoder decoder = null;

        try {
            decoder = new XMLDecoder(new FileInputStream("utilisateur.xml"));
            Visiteur.setLPersonnes((ArrayList<Visiteur>) decoder.readObject()); 
            //final Visiteur visiteur = (Visiteur) decoder.readObject();
            for (Visiteur uv : Visiteur.getLPersonnes()) {
                System.out.println(uv.getPrenom());
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (decoder != null) {
                decoder.close();
            }
        }
    }
}