package com.ubo.tp.twitub.observeurPattern;

import com.ubo.tp.twitub.datamodel.User;

public interface ObserveurInscription {


    public void updateConnexion();

    void updateInscription();

    public void connecte(User user);

}

