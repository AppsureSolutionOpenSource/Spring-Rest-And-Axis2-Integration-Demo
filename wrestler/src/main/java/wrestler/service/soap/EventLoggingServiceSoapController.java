package wrestler.service.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wrestler.entities.Event;
import wrestler.service.base.EventLoggingService;

import java.util.List;

public class EventLoggingServiceSoapController {

    @Autowired
    private EventLoggingService eventLoggingService;

    public List<Event> getEvents(int count, int skip ){
        return eventLoggingService.getEvents(count, skip);
    }
    public Long createInfo(String description,String user ){
        return eventLoggingService.createInfo(description, user);
    }
    public Long createWarn(String description, String user ){
        return eventLoggingService.createWarn(description, user);
    }
    public Long createError(String description, String user){
        return eventLoggingService.createError(description, user);
    }
}
