package pl.com.bottega.photostock.sales.model.deal;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Offer {

    private Set<Picture> pictures = new HashSet<>();
    private Date date = new Date();
    private boolean isAgreeByClient = false;

    public Offer(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public boolean isAgreeByClient() {
        return isAgreeByClient;
    }

    public void setAgreeByClient(boolean agreeByClient) {
        isAgreeByClient = agreeByClient;
    }

    public double getTotalCost() {
        double totalSum = 0;
        for (Picture picture : pictures) {
            for (Resolution res : picture.getResolutions()) {
                totalSum += res.getPrice();
            }
        }
        return totalSum;
    }

    public int getItemsCount() {
        return pictures.size();
    }

    public Set<Picture> getItems() {
        return pictures;
    }
}
