package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class ArtistHibernateDAO {

    public static void saveArtist(ArtistHibernate artist) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            // session.persist(artist);
            session.save(artist);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public static void updateArtist(ArtistHibernate artist) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            // session.merge(artist);
            session.saveOrUpdate(artist);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static void updateArtist2(int id, String name) {

        Transaction transaction = null;

        // ArtistHibernate artist = getArtist(id);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            ArtistHibernate artist = session.get(ArtistHibernate.class, id);
            artist.setName(name);
            // session.merge(artist);
            session.saveOrUpdate(artist);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static void deleteArtist(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            ArtistHibernate artist = session.get(ArtistHibernate.class, id);
            if (artist != null) {
                session.delete(artist);
            }
            transaction.commit();
            System.out.println("Deleted artist");

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static ArtistHibernate getArtist(int id) {

        Transaction transaction = null;
        ArtistHibernate artist = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            artist = session.get(ArtistHibernate.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return artist;

    }

    @SuppressWarnings("unchecked")
    public static List<ArtistHibernate> getAllArtists() {

        Transaction transaction = null;
        List<ArtistHibernate> listOfArtists = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            listOfArtists = session.createQuery("from ArtistHibernate").getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return listOfArtists;

    }

}
