package com.gregheartsfield.revelation;

import com.google.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevelationServer {
    final Logger logger = LoggerFactory.getLogger(RevelationServer.class);
    MigrationProvider mp = null;

    @Inject
    public RevelationServer(MigrationProvider mp) {
        this.mp = mp;
        logger.info("Revelation Server instantiated");
    }
    
    public void run() {
        logger.info("Running Revelation");
        // Get change log from source (MigrationProvider)
        // Retrieve change log from target (LogManager does this)
        // Calculate work to do (ChangeLog class?)
        // Apply changes to datastore (DataStore apply/unapply)
        // Report results
    }
}
