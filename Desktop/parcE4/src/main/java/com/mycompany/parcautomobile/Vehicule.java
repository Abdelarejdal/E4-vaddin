/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import com.vaadin.data.util.BeanItemContainer;


/**
 *
 * @author user
 */
public class Vehicule {

    private int id;
    private String marque;
    private String modele;
    private double prix;
    private static BeanItemContainer<Vehicule> vehicules = new BeanItemContainer<>(Vehicule.class);

    public Vehicule() {
    }

    public Vehicule(int id, String marque, String modele, double prix) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
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

    public static BeanItemContainer<Vehicule> getVehicules() {
        return vehicules;
    }

}
