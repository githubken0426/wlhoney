package cn.honey.home.service;


import cn.honey.home.bean.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> selectPhotosByAlbums(String album);
}
