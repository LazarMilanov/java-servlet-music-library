package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="albums")
public class AlbumHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artistid", referencedColumnName = "Id")
    private ArtistHibernate artist;

    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrackHibernate> tracks;

    public AlbumHibernate(int id, String title, ArtistHibernate artist, List<TrackHibernate> tracks) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public AlbumHibernate(String title, ArtistHibernate artist, List<TrackHibernate> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public AlbumHibernate() {}

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

    public ArtistHibernate getArtist() {
        return artist;
    }

    public void setArtist(ArtistHibernate artist) {
        this.artist = artist;
    }

    public List<TrackHibernate> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackHibernate> tracks) {
        this.tracks = tracks;
    }
}
