package cn.honey.home.service.photo;


import cn.honey.home.bean.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> selectPhotosByAlbums(Integer albumId);
}
