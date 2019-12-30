package cn.honey.home.service.photo;


import cn.honey.home.bean.Photo;
import cn.honey.home.dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDao photoDao;

    @Override
    public List<Photo> findPhotosByAlbumId(Long albumId) {
        return photoDao.findPhotosByAlbumId(albumId);
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoDao.save(photo);
    }
}
