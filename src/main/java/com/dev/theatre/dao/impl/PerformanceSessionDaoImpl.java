package com.dev.theatre.dao.impl;

import com.dev.theatre.dao.PerformanceSessionDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.PerformanceSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private final SessionFactory sessionFactory;

    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> query = session.createQuery("select ms from "
                            + "PerformanceSession ms "
                            + "inner join ms.performance m "
                            + "where m.id = :id "
                            + "and date_format(ms.showTime, '%Y-%m-%d') = :date",
                    PerformanceSession.class);
            query.setParameter("id", movieId);
            query.setParameter("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find performance sessions by movie id "
                    + movieId + " and by movie date " + date.toString(), e);
        }
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert performance session entity "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update performance session: "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<PerformanceSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.load(PerformanceSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get performance session with id: " + id, e);
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PerformanceSession performanceSession = session.load(PerformanceSession.class, id);
            session.delete(performanceSession);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete performance session with  id: " + id,
                    e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
