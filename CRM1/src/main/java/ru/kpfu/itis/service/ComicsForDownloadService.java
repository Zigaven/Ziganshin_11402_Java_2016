package ru.kpfu.itis.service;

import ru.kpfu.itis.entities.ComicsForDownloadEntity;

import java.util.List;

/**
 * Created by ruslanzigansin on 04.05.16.
 */
public interface ComicsForDownloadService {
    ComicsForDownloadEntity getComicsByName(String name);
}
