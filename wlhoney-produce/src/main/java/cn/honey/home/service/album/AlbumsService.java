package cn.honey.home.service.album;


import cn.honey.home.bean.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> findAlbumsByYear(Integer year);

    Album findAlbumById(long albumId);

    Album saveAlbum(Album album);
}
