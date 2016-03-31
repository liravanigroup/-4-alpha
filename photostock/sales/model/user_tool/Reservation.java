package pl.com.bottega.photostock.sales.model.user_tool;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.deal.Offer;
import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.users.Client;

import java.util.*;

public class Reservation {

    private Client owner;
    private Set<Picture> pictures = new HashSet<>();
    private Date date = new Date();

    public Reservation(Client owner) {
        this.owner = owner;
    }

    public void add(Picture picture) {
        add(picture, picture.getMaxResolution());
    }

    public void add(Picture picture, String[] picturesResolutions) {
        for (String nameResolution : picturesResolutions) {
            add(picture, nameResolution);
        }
    }

    public void manualAddPicturesFromLightBox(LightBox testLightBox, int[] numberOfPictures) {
        for (int indexNumber : numberOfPictures) {
            Picture picture = testLightBox.getPictureByIndex(indexNumber);
            add(picture, picture.getMaxResolution());
        }
    }

    public void addAllPicturesFromLightBox(LightBox lightboxToReservation) {
        List<Picture> lbxPictures = lightboxToReservation.getPictures();
        for (Picture pic : lbxPictures) {
            add(pic);
        }
    }

    public void add(Picture picture, String pictureResolutions) {
        Picture addedPicture = picture.clone();

        List<Resolution> resolutions = picture.getResolutions();
        List<Resolution> changedReservation = new ArrayList<>();

        for (Resolution res : resolutions) {
            if (res.getNameResolution() == pictureResolutions && res.isAvialable()) {
                Resolution cloneResolution = res.clone();
                res.setAviable(false);
                changedReservation.add(cloneResolution);
                addedPicture.setResolutions(changedReservation);
                if (!pictures.contains(addedPicture))
                    pictures.add(addedPicture);
            }
        }
    }

    public void remove(Picture picture) {
        if (pictures.contains(picture))
            pictures.remove(picture);
    }

    public Offer generateOffer() {
        return new Offer(pictures);
    }

    public int getItemsCount() {
        return pictures.size();
    }



    @Override
    public String toString() {
        return getPictureList();
    }

    private String getPictureList() {
        StringBuilder s = new StringBuilder();
        for (Picture pic : pictures) {
            s.append(pic.getName()).append(" ");
            for (Resolution res : pic.getResolutions()) {
                s.append(res.getNameResolution()).append(" ").append(res.getPrice());
            }
            s.append("").append("\n");
        }
        return s.toString();
    }


}
