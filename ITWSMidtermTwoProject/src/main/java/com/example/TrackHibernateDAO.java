package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrackHibernateDAO {

    public static void saveTrack(TrackHibernate track) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(track);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public static void updateTrack(TrackHibernate track) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(track);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public static void deleteTrack(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            TrackHibernate track = session.get(TrackHibernate.class, id);
            if (track != null) {
                session.delete(track);
            }
            transaction.commit();
            System.out.println("Deleted album");

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static TrackHibernate getTrack(int id) {

        Transaction transaction = null;
        TrackHibernate track = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            track = session.get(TrackHibernate.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return track;

    }

    @SuppressWarnings("unchecked")
    public static List<TrackHibernate> getTracksByArtist(int id) {
        Transaction transaction = null;
        List<TrackHibernate> listOfTracks = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            listOfTracks = session.createQuery("select t from TrackHibernate t where t.album.artist.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return listOfTracks;
    }

    @SuppressWarnings("unchecked")
    public static List<TrackHibernate> getAllTracks() {

        Transaction transaction = null;
        List<TrackHibernate> listOfTracks = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            listOfTracks = session.createQuery("from TrackHibernate").getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return listOfTracks;

    }

}
