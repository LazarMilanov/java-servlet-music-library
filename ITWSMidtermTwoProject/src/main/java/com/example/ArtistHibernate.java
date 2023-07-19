package com.example;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artists")
public class ArtistHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AlbumHibernate> albums = new ArrayList<>();

    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="albums",
            joinColumns = { @JoinColumn(name="artistid", referencedColumnName = "Id") },
            inverseJoinColumns = { @JoinColumn(name="Id", referencedColumnName = "albumid") }

    )
    private List<TrackHibernate> tracks;*/

    public ArtistHibernate(int id, String name, List<AlbumHibernate> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;

    }

    public ArtistHibernate(String name, List<AlbumHibernate> albums) {
        this.name = name;
        this.albums = albums;
    }

    public ArtistHibernate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistHibernate(String name) {
        this.name = name;
    }

    public ArtistHibernate() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlbumHibernate> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumHibernate> albums) {
        this.albums = albums;
    }

}
