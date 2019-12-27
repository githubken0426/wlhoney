package cn.honey.home.service.album;

import cn.honey.home.bean.Album;
import cn.honey.home.dao.AlbumsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("albumsService")
public class AlbumsServiceImpl implements AlbumsService {
    @Autowired
    private AlbumsDao albumsDao;

    @Override
    public List<Album> findAlbumsByYear(Integer year) {
        return albumsDao.findAlbumsByYear(year);
    }

    @Override
    public Album findAlbumById(long albumId) {
        return albumsDao.findAlbumById(albumId);
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumsDao.save(album);
    }
}
