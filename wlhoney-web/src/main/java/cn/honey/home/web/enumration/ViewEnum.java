package cn.honey.home.web.enumration;

public enum ViewEnum {
    ALBUMS("albums"),
    UPLOAD_ALBUM("upload-album"),
    UPLOAD_PHOTOS("upload-photos"),
    PHOTO_CONVERFLOW("photo-coverflow");

    private ViewEnum(String view) {
        this.view = view;
    }

    private String view;

    public String view() {
        return view;
    }
}
