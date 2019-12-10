package cn.honey.home.dao;

import cn.honey.home.bean.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumsDao {
    List<Album> getAlbumsByYear(Integer year);
}
