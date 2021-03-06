package cn.honey.home.service.photo;


import cn.honey.home.bean.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> findPhotosByAlbumId(Long albumId);

    Photo savePhoto(Photo photo);

    Photo findPhotoById(Long id);
}
