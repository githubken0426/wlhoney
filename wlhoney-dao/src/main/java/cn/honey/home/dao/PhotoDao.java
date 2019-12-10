package cn.honey.home.dao;

import cn.honey.home.bean.Photo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao {
    List<Photo> selectPhotosByAlbums(Integer album);
}
