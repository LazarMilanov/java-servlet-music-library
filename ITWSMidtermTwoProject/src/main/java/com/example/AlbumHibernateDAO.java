package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AlbumHibernateDAO {

    public static void saveAlbum(AlbumHibernate album) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(album);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public static void updateAlbum(AlbumHibernate album) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.saveOrUpdate(album);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static void updateAlbum2(int id, String title, ArtistHibernate artist) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            AlbumHibernate album = session.get(AlbumHibernate.class, id);
            album.setTitle(title);
            album.setArtist(artist);
            session.saveOrUpdate(album);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static void deleteAlbum(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            AlbumHibernate album = session.get(AlbumHibernate.class, id);
            if (album != null) {
                session.delete(album);
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

    public static AlbumHibernate getAlbum(int id) {

        Transaction transaction = null;
        AlbumHibernate album = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            album = session.get(AlbumHibernate.class, id);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return album;

    }

    @SuppressWarnings("unchecked")
    public static List<AlbumHibernate> getAllAlbums() {

        Transaction transaction = null;
        List<AlbumHibernate> listOfAlbums = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            listOfAlbums = session.createQuery("from AlbumHibernate ").getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return listOfAlbums;

    }

}
