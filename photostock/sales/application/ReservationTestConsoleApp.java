package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.deal.Offer;
import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.user_tool.Reservation;
import pl.com.bottega.photostock.sales.model.users.Client;

import java.util.ArrayList;
import java.util.List;


public class ReservationTestConsoleApp {
    public static void main(String[] args) {

        List<Resolution> resolutionList = new ArrayList<>();
        Resolution resolution = new Resolution(1024,768,10);
        resolutionList.add(resolution);

        Picture mustang = new Picture("nr1", "cat", new String[]{"ford", "mustang"}, true, "M", resolutionList);
        Picture mustang2 = new Picture("nr1", "cat", new String[]{"ford", "mustang"}, true, "M",resolutionList);


        Client takiSobieClient = new Client("Zegrzysław", "tajny", 0);

        Reservation reservation = new Reservation(takiSobieClient);
        reservation.add(mustang);
        reservation.add(mustang2);

        System.out.println(reservation.toString());

        Offer ofertaDlaZegrzyslawa = reservation.generateOffer();
        int count = ofertaDlaZegrzyslawa.getItemsCount();
        System.out.println("Ilość pozycji w ofercie: " + count);
    }
}