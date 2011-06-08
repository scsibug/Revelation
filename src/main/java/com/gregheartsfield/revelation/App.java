package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new RevelationModule());
        RevelationServer revServ = injector.getInstance(RevelationServer.class);
        revServ.run();
    }
}
