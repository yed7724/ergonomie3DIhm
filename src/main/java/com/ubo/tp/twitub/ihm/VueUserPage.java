package com.ubo.tp.twitub.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ubo.tp.twitub.datamodel.User;

public class VueUserPage extends JPanel{
    User user;

    public VueUserPage(User user) {
        this.user = user;

        String name = this.user.getName();
        String username = this.user.getUserTag();

        // Créer les étiquettes pour afficher les messages
        JLabel welcomeLabel = new JLabel("Bienvenue");
        JLabel nameLabel = new JLabel("Nom : " + name);
        JLabel usernameLabel = new JLabel("Pseudo : " + username);




        // Ajouter les panneaux à la fenêtre
        this.add(welcomeLabel, BorderLayout.NORTH);
        this.add(nameLabel, BorderLayout.CENTER);
        this.add(usernameLabel, BorderLayout.SOUTH);
    }
}