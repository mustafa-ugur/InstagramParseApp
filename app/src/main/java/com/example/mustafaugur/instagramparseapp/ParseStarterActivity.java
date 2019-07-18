package com.example.mustafaugur.instagramparseapp;


import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vhcefeH0N1nfjAbGAX9ZBafk6ZAw0in6RRFnL1na")
                .clientKey("RbvI7FO5FjXFxkHku6u2pvsmuSqUHpQVbC89XAOo")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
