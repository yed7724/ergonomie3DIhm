package com.ubo.tp.twitub.observeurPattern;

public interface ObservbleInscriptionConnexion {

    public void addObservateur(ObserveurInscription o);
    public void removeObservateur(ObserveurInscription o);
    public void notifyObservateurInscription();

    public void notifyObservateurConnexion();

    public void notifyObservateurConnecte();


}
