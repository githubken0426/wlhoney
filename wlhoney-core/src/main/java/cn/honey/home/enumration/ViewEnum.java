package cn.honey.home.enumration;

public enum ViewEnum {
    ALBUMS("albums"),
    UPLOAD_ALBUM("upload-album"),
    UPLOAD_PHOTOS("upload-photos"),

    PHOTO_CONVERFLOW("photo-coverflow"),
    PHOTO_CUBE("photo-cube"),PHOTO_ZOOM("photo-zoom");

    private ViewEnum(String view) {
        this.view = view;
    }

    private String view;

    public String view() {
        return view;
    }
}
