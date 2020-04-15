package wrestler.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wrestler.entities.Event;
import wrestler.service.base.EventLoggingService;
import wrestler.service.base.RandomNumbersService;

import java.util.List;

@RestController
public class EventLoggingServiceRestController {
    public final static String PATH_GET_EVENTS = "/api/rest/getEvents";
    public final static String PATH_CREATE_INFO = "/api/rest/createInfo";
    public final static String PATH_CREATE_WARN = "/api/rest/createWarn";
    public final static String PATH_CREATE_ERROR = "/api/rest/createError";
    @Autowired
    private EventLoggingService eventLoggingService;

    @GetMapping(path = PATH_GET_EVENTS, produces = "application/json")
    @ResponseBody
    public List<Event> getEvents(@RequestParam(value = "count", defaultValue = "0") int count, @RequestParam(value = "skip", defaultValue = "0") int skip ){
        return eventLoggingService.getEvents(count, skip);
    }
    @PostMapping(path = PATH_CREATE_INFO, produces = "application/json")
    @ResponseBody
    public Long createInfo(@RequestParam(value = "description", defaultValue = "") String description, @RequestParam(value = "user", defaultValue = "") String user ){
        return eventLoggingService.createInfo(description, user);
    }
    @PostMapping(path = PATH_CREATE_WARN, produces = "application/json")
    @ResponseBody
    public Long createWarn(@RequestParam(value = "description", defaultValue = "") String description, @RequestParam(value = "user", defaultValue = "") String user ){
        return eventLoggingService.createWarn(description, user);
    }
    @PostMapping(path = PATH_CREATE_ERROR, produces = "application/json")
    @ResponseBody
    public Long createError(@RequestParam(value = "description", defaultValue = "") String description, @RequestParam(value = "user", defaultValue = "") String user ){
        return eventLoggingService.createError(description, user);
    }
}
