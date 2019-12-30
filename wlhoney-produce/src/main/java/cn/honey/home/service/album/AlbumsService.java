package cn.honey.home.service.album;


import cn.honey.home.bean.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> findAlbumsByYear(Integer year);

    List<Album> saveAllAlbums(List<Album> albums);

    Album findAlbumById(long albumId);

    Album saveAlbum(Album album);
}
