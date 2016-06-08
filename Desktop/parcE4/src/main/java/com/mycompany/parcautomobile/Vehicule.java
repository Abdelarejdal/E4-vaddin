/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import java.util.ArrayList;
import java.util.List;


// test commentaire à supprimer

/**
 *
 * @author abdel
 */
public class Vehicule implements java.io.Serializable {

    private int id;
    private String marque;
    private String modele;
 
    private double prix;
    private String gamme;
    private static BeanItemContainer<Vehicule> vehicules = new BeanItemContainer<>(Vehicule.class);
    
    public Vehicule() {
    }

    public Vehicule(int id, String marque, String modele, double prix, String gamme) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.gamme = gamme;
        this.vehicules.addBean(this);
    }

    public String getMarque() {
        return marque;
        
    }

    public String getModele() {
        return modele;
    }

    public double getPrix() {
        return prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGamme() {
        return gamme;
    }

    public void setGamme(String gamme) {
        this.gamme = gamme;
    }
    
    public static BeanItemContainer<Vehicule> getVehicules() {
        return vehicules;
    }

     /**
     *
     * @param prix
     * @return la collection de véhicule ayant un prix suppérieur a la variable prix
     */
    public static BeanItemContainer<Vehicule> getVehiculesPrixHaut(double prix) {
        BeanItemContainer<Vehicule> lesVehiculesPrixHaut = new BeanItemContainer<>(Vehicule.class);
        List<Vehicule> listeVehicule = vehicules.getItemIds();
        for( Vehicule unVehicule : listeVehicule){
            if(unVehicule.getPrix()> prix){
                lesVehiculesPrixHaut.addBean(unVehicule);
            }
        } 
        return lesVehiculesPrixHaut;
    }
    public static BeanItemContainer<Vehicule> getVehiculesPrixBas(double prix) {
        BeanItemContainer<Vehicule> lesVehiculesPrixBas = new BeanItemContainer<>(Vehicule.class);
        List<Vehicule> listeVehicule = vehicules.getItemIds();
        for( Vehicule unVehicule : listeVehicule){
            if(unVehicule.getPrix()< prix){
                lesVehiculesPrixBas.addBean(unVehicule);
            }
        } 
        return lesVehiculesPrixBas;
    }

    
}