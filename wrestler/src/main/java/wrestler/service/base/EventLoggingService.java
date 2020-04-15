package wrestler.service.base;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wrestler.entities.Event;
import wrestler.entities.EventType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;

@Component
public class EventLoggingService {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public Long createError(String description, String user){
        return createEvent(EventType.Error, description, user);
    }

    @Transactional
    public Long createWarn(String description, String user){
        return createEvent(EventType.Warn, description, user);
    }

    @Transactional
    public Long createInfo(String description, String user){
        return createEvent(EventType.Info, description, user);
    }

    @Transactional
    public List<Event> getEvents(int count, long skipIdsLowerThan){

        Query query = entityManager.createNativeQuery("SELECT * FROM TBL_EVENT WHERE COL_ID > :skip ORDER BY COL_ID ASC LIMIT :count", Event.class);
        query.setParameter("skip",skipIdsLowerThan);
        query.setParameter("count", count);
        List<Event> events = query.getResultList();
        return events;
    }


    private Long createEvent(EventType eventType, String description, String user){
        Event event = new Event();
        event.setEventType(eventType);
        event.setDescription(description);
        event.setUser(user);
        entityManager.persist(event);
        entityManager.flush();
        return event.getId();
    }
}
