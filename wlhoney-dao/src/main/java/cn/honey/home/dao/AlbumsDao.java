package cn.honey.home.dao;

import cn.honey.home.bean.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumsDao extends JpaRepository<Album, Long> {

    @Query(value = "select * from wl_album where YEAR(create_time)=:year ", nativeQuery = true)
    List<Album> findAlbumsByYear(@Param("year") Integer year);

}
