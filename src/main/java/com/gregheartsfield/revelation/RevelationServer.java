package com.gregheartsfield.revelation;

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
        // Get change log from source (MigrationProvider)
        // Retrieve change log from target (LogManager does this)
        // Calculate work to do (ChangeLog class?)
        // Apply changes to datastore (DataStore apply/unapply)
        // Report results
    }
}
