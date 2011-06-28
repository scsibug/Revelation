package com.gregheartsfield.revelation;

import com.google.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevelationServer {
    final Logger logger = LoggerFactory.getLogger(RevelationServer.class);
    MigrationProvider mp = null;
    LogManager lm = null;

    @Inject
    public RevelationServer(MigrationProvider mp, LogManager lm) {
        this.mp = mp;
        this.lm = lm;
        logger.info("Revelation Server instantiated");
    }
    
    public void run() {
        ChangeLog startingChangeLog = null;
        logger.info("Running Revelation");
        // Detect if MigrationProvider is available.
        if (mp.isInitialized()) {
            // Get change log from source (MigrationProvider)
            startingChangeLog = mp.getChangeLog();
        } else {
            logger.error("Migration Provider needs to be initialized before attempting to run migrations.");
            System.exit(1);
        }
        // Retrieve change log from target (LogManager does this)
        if (lm.isInitialized()) {
            logger.info("Found "+startingChangeLog.size()+" changes");
            logger.info("Log Manager found, changes retrieved.");
        } else {
            logger.error("Log Manager needs to be initialized before attempting to run migrations.");
            System.exit(1);
        }
        
        // Calculate work to do (ChangeLog class?)
        // Apply changes to datastore (DataStore apply/unapply)
        // Report results
    }
}
