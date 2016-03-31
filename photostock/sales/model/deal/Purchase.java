package pl.com.bottega.photostock.sales.model.deal;

import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.users.Client;

import java.util.Date;
import java.util.Set;

public class Purchase {

    private final Client owner;

    private final Date createDate;

    private final Set<Picture> pictures;

    public Purchase(Client owner, Set<Picture> pictures) {
        this.owner = owner;
        this.pictures = pictures;
        this.createDate = new Date();
    }
}
