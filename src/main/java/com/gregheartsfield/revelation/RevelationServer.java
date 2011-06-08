package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.Inject;

public class RevelationServer
{
    @Inject
    public RevelationServer()
    {
        System.out.println("Revelation Server instantiated");
    }
    
    public void run() {
        System.out.println("Running Revelation");
    }
}
