package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{

    public static void main( String[] args )
    {
        final Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Creating guice injector");
        Injector injector = Guice.createInjector(new RevelationModule());
        RevelationServer revServ = injector.getInstance(RevelationServer.class);
        revServ.run();
    }

}
