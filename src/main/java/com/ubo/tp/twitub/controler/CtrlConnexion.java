package com.ubo.tp.twitub.controler;

import com.ubo.tp.twitub.datamodel.IDatabase;
import com.ubo.tp.twitub.datamodel.User;
import com.ubo.tp.twitub.ihm.VueUserPage;
import com.ubo.tp.twitub.observeurPattern.ObservbleInscriptionConnexion;
import com.ubo.tp.twitub.observeurPattern.ObserveurInscription;

import javax.swing.*;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class CtrlConnexion implements ObservbleInscriptionConnexion {

private Set<ObserveurInscription> observeurs = new HashSet<>();

    private IDatabase mDatabase;

    private User user;

    public CtrlConnexion( IDatabase mDatabase){

        this.mDatabase = mDatabase;
        this.user = null;
    }

    public void logout(){
        this.user = null;
    }

    public User getUser() {
        return this.user;
    }

    public User checkConnexion(String name, String password){
        User user = null;
        for(User u : this.mDatabase.getUsers()) {
            if(u.getUserTag().equals(name) && u.getUserPassword().equals(password)) {
                user = u;
                this.user = u;

                System.out.println("Connecte");
                this.notifyObservateurConnecte();
                return user;

            }
        }
        if(user == null) {

            System.out.println("Utilisateur introuvable");
            return null;
        }
        return null;
    }

    @Override
    public void addObservateur(ObserveurInscription o) {
        this.observeurs.add(o);


    }

    @Override
    public void removeObservateur(ObserveurInscription o) {
        this.observeurs.remove(o);

    }

    @Override
    public void notifyObservateurInscription() {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyObservateurConnexion() {

    }

    @Override
    public void notifyObservateurConnecte() {
        for(ObserveurInscription o : this.observeurs){
            o.connecte(this.user);
        }

    }
}