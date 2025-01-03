package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EventDALImp implements EventDAL {
    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        return event;
    }

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        List<Event> events = session.createQuery(
                "select event from Event event", Event.class
        ).getResultList();
        return events;
    }

    @Override
    @Transactional
    public String save(Event item) {
        Session session = entityManager.unwrap(Session.class);
        session.save(item);
        return "the event was saved successfully";
    }
}





















