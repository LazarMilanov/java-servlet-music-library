package com.example;

import javax.persistence.*;

@Entity
@Table(name="tracks")
public class TrackHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "length")
    private String length;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "albumid", referencedColumnName = "Id")
    private AlbumHibernate album;


    public TrackHibernate(int id, String title, String length, String price, AlbumHibernate album) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.price = price;
        this.album = album;
    }

    public TrackHibernate(String title, String length, String price, AlbumHibernate album) {
        this.title = title;
        this.length = length;
        this.price = price;
        this.album = album;
    }

    public TrackHibernate() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public AlbumHibernate getAlbum() {
        return album;
    }

    public void setAlbum(AlbumHibernate album) {
        this.album = album;
    }
}
