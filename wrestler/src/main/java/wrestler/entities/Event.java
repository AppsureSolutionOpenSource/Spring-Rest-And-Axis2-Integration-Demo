package wrestler.entities;

import javax.persistence.*;

@Entity
@Table(name="TBL_EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COL_ID", nullable=false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="COL_EVENT_TYPE")
    private EventType eventType;

    @Column(name="COL_EVENT_DESCRIPTION",length = 1024,nullable = true)
    private String description;

    @Column(name="COL_EVENT_GENERATED_BY",length = 1024,nullable = false)
    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
