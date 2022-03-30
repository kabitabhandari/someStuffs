package com.example.demo121.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingLevelController {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingLevelController.class);

    @GetMapping("/logs")
    public String myLogsLevels() {
        LOG.trace("This is a TRACE log");
        LOG.debug("This is a DEBUG log");
        LOG.info("This is an INFO log");
        LOG.error("This is an ERROR log");
        return "done";
    }

}
/*
Off --> no logs
Fatal -->  fatal
Error -->  fatal, error
Warn -->  fatal, error, warn
Info --> fatal, error, warn, info
Debug --> fatal, error, warn, info, debug
Trace --> fatal, error, warn, info, debug, trace
All -->  fatal, error, warn, info, debug, trace, all
 */