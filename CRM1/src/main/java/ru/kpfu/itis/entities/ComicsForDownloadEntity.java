package ru.kpfu.itis.entities;

import javax.persistence.*;

/**
 * Created by ruslanzigansin on 01.05.16.
 */
@Entity
@Table(name = "comics_download")
public class ComicsForDownloadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "page_number", nullable = false)
    private int page_number;

    @Column(name = "path", nullable = false)
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
