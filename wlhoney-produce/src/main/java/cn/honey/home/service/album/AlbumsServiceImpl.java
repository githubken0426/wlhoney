package cn.honey.home.service.album;

import cn.honey.home.bean.Album;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("albumsService")
public class AlbumsServiceImpl implements AlbumsService{
    @Override
    public List<Album> getAlbumsByYear(String year) {
        return null;
    }
}
