package com.dev.theatre.dao.impl;

import com.dev.theatre.dao.TheatreStageDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.TheatreStage;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreStageDaoImpl implements TheatreStageDao {
    private final SessionFactory sessionFactory;

    public TheatreStageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(theatreStage);
            transaction.commit();
            return theatreStage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert theatre stage entity " + theatreStage,
                    e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<TheatreStage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            List<TheatreStage> theatreStages = session.createQuery("from TheatreStage ",
                    TheatreStage.class).getResultList();
            return theatreStages;
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all theatre halls", e);
        }
    }

    @Override
    public Optional<TheatreStage> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.load(TheatreStage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get theatre hall with id: " + id);
        }
    }
}
