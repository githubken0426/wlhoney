package cn.honey.home.dao;

import cn.honey.home.bean.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Long> {

    @Query(value = "select * from wl_photo where flag='Y' and  album_id=:albumId ", nativeQuery = true)
    List<Photo> findPhotosByAlbumId(@Param("albumId") Long albumId);

    Photo findPhotoById(Long id);
}
