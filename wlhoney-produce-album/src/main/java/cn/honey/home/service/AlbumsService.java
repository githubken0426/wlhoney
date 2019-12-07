package cn.honey.home.service;


import cn.honey.home.bean.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> getAlbumsByYear(String year);
}
