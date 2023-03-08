package com.ubo.tp.twitub.ihm;

import com.ubo.tp.twitub.datamodel.Twit;

import javax.swing.*;
import java.awt.*;

public class VueAfficherTweet {


    public VueAfficherTweet(Twit twit) {

       // twit.getUserTags();

        JPanel unTweet = new JPanel();
        unTweet.setLayout(new BoxLayout(unTweet, BoxLayout.Y_AXIS));
        unTweet.setBorder(BorderFactory.createLineBorder(Color.black));
        unTweet.setPreferredSize(new Dimension(200, 100));
        JLabel text = new JLabel(twit.getText());
        text.setFont(new Font("Arial", Font.PLAIN, 20));


        unTweet.add(text);

    }


}
