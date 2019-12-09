package cn.honey.home.service.photo;


import cn.honey.home.bean.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    @Override
    public List<Photo> selectPhotosByAlbums(String album) {
        return null;
    }
}
