package com.ubo.tp.twitub.controler;

import com.ubo.tp.twitub.datamodel.IDatabase;
import com.ubo.tp.twitub.datamodel.Twit;
import com.ubo.tp.twitub.datamodel.User;

public class CtrlAjoutTweet {




    public CtrlAjoutTweet() {


    }

    public void addTwit(String twit, User User,IDatabase mDatabase) {
        //Twit newTwit = new Twit(randomUser, twit);
        //mDatabase.addTwit(newTwit);
        Twit newTwit = new Twit(User, twit);
        mDatabase.addTwit(newTwit);
    }

}
