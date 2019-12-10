package cn.honey.home.dao;

import cn.honey.home.bean.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Long> {
    List<Photo> findPhotosByAlbum(Integer album);
}
