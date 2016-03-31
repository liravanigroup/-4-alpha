package pl.com.bottega.photostock.sales.model.users;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.ArrayList;
import java.util.List;

import static pl.com.bottega.photostock.sales.model.common.CurrencyConverter.convertUSDToCradit;
import static pl.com.bottega.photostock.sales.model.common.RandomValues.getRandomUID;
import static pl.com.bottega.photostock.sales.model.common.Resolution.getResolutionsList;
import static pl.com.bottega.photostock.sales.model.data_base.DataBase.dataBase;

/**
 * Sergej Povzaniuk
 * 2016-03-30.
 */
public class Fotograf {

    private String name;
    private double amount;

    public Fotograf(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }


    public void addPicture(String pictureName, String[] tags, String heightXwidht, String[] manualPrices) {

        String[] parts = heightXwidht.split("x");
        int widthPicture = Integer.parseInt(parts[0]);
        int heightPicture = Integer.parseInt(parts[1]);
        Resolution resolution = new Resolution(widthPicture, heightPicture, 0);
        String maxResolution = resolution.getNameResolution();

        List<Resolution> resolutions = getResolutionsList(resolution, manualPrices);

        addPictureToDataBase(new Picture(getRandomUID(), pictureName, tags, true, maxResolution, resolutions));
    }

    public void addPicture(String pictureName, String[] tags, String heightXwidhtXprice) {
        String[] parts = heightXwidhtXprice.split("x");

        int heightPicture = Integer.parseInt(parts[0]);
        int widthPicture = Integer.parseInt(parts[1]);
        double price = Double.parseDouble(parts[2]);
        price = convertUSDToCradit(price);

        Resolution resolution = new Resolution(widthPicture, heightPicture, price);
        String maxResolution = resolution.getNameResolution();

        List<Resolution> resolutions = new ArrayList<Resolution>();
        resolutions.add(resolution);

        addPictureToDataBase(new Picture(getRandomUID(), pictureName, tags, true, maxResolution, resolutions));
    }


    private void addPictureToDataBase(Picture picture) {
        dataBase.insertPicture(picture);
    }
}
