package pl.com.bottega.photostock.sales.model.data_base;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Sergej Povzaniuk
 * 2016-03-30.
 */
public class DataBase {

    public static DataBase dataBase = new DataBase("Pictures", "Admin", "1234");

    private final String DB_NAME;
    private final String DB_USER;
    private final String DB_PASSWORD;

    private List<Picture> allPictures = new ArrayList<Picture>();

    public DataBase(String DB_NAME, String DB_USER, String DB_PASSWORD) {
        this.DB_NAME = DB_NAME;
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public void insertPicture(Picture picture) {
        allPictures.add(picture);
    }

    public void updatePicture(Picture oldPicture, Picture newPicture) {
        allPictures.remove(oldPicture);
        allPictures.add(newPicture);
    }

    public void deletePicture(Picture picture) {
        allPictures.remove(picture);
    }

    public String selectAllPicture() {
        StringBuilder s = new StringBuilder();
        for (Picture pic :
                allPictures) {
            s.append(pic.getName()).append(" ").append(pic.isAvailable()).append(" ").append(" Size: ");
            for (Resolution res : pic.getResolutions()) {
                s.append(res.getNameResolution()).append(" ").append(res.getPrice()).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public Picture[] toArray() {
        Picture[] picArray = new Picture[allPictures.size()];
        int iterator = 0;
        for (Picture pic : allPictures) {
            picArray[iterator] = pic;
            iterator++;
        }
        return picArray;
    }
}
