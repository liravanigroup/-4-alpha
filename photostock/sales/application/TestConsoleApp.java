package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.deal.Offer;
import pl.com.bottega.photostock.sales.model.deal.Purchase;
import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.user_tool.LightBox;
import pl.com.bottega.photostock.sales.model.user_tool.Reservation;
import pl.com.bottega.photostock.sales.model.users.Client;
import pl.com.bottega.photostock.sales.model.users.Fotograf;

import static pl.com.bottega.photostock.sales.model.data_base.DataBase.dataBase;

/**
 * Sergej Povzaniuk
 * 2016-03-30.
 */
public class TestConsoleApp {

    public static void main(String[] args) {


        Fotograf fotograf = new Fotograf("Mariusz", 0);

        fotograf.addPicture("My_Black_Cat0", new String[]{"cat", "black_cat", "my_cat"}, "5920x1080x12");
        fotograf.addPicture("My_Black_Cat1", new String[]{"cat", "black_cat", "my_cat"}, "3920x1080x12");
        fotograf.addPicture("My_Black_Cat2", new String[]{"cat", "black_cat", "my_cat"}, "1920x1080x12");
        fotograf.addPicture("My_Black_Cat3", new String[]{"cat", "black_cat", "my_cat"}, "1920x1080x12");
        fotograf.addPicture("My_Black_Cat4", new String[]{"cat", "black_cat", "my_cat"}, "1920x1080x12");
        fotograf.addPicture("My_Black_Cat5", new String[]{"cat", "black_cat", "my_cat"}, "5920x1080", new String[]{"XXLx10", "XLx8", "Lx6", "Mx4", "Sx2"});
        fotograf.addPicture("My_Black_Cat6", new String[]{"cat", "black_cat", "my_cat"}, "1920x1080x12");
        fotograf.addPicture("My_Black_Cat7", new String[]{"cat", "black_cat", "my_cat"}, "1920x1080", new String[]{"Mx4", "Sx2"});

        Client client = new Client("Patrik", "Lublin", false, 0, 0, 0);
        client.recharge(100);//Payment was completed in USD (change Rate is 8 Credit : 1 USD)

        //Get pictures by client query
        Picture[] pictures = dataBase.toArray();

        //Client have to compare some pictures inside LightBox #1
        LightBox testLightBox = new LightBox(client);
        testLightBox.add(pictures[0]);
        testLightBox.add(pictures[1]);
        testLightBox.add(pictures[2]);
        testLightBox.add(pictures[5]);
        testLightBox.add(pictures[6]);

        //Test duplicate protected
        //testLightBox.add(pictures[5]);

        //Client have to compare some pictures inside LightBox #2
        LightBox catsLightBox = new LightBox(client);
        catsLightBox.add(pictures[0]);
        catsLightBox.add(pictures[2]);
        catsLightBox.add(pictures[5]);
        catsLightBox.add(pictures[7]);

        //It is my colleague
        Client colleague = new Client("Colega Patrika", "Lublin", false, 0, 0, 0);

        //I want to share my lightBox for my colleague
        client.shareLightBox(catsLightBox, colleague);


        //Other client bought one of client selected Picture
//        dataBase.updatePicture(pictures[0], pictures[0].getBoughtStain());
//        dataBase.updatePicture(pictures[1], pictures[1].getBoughtStain());

        //Client created reservation
        Reservation reservation = new Reservation(client);

        //Client reserved a Picture without LightBox
        reservation.add(pictures[5], new String[]{"S", "L", "M"});
//        reservation.add(pictures[5], "XL");
//        reservation.add(pictures[0]);

        //Client reserved one Picture or some Pictures from LightBox
        //reservation.manualAddPicturesFromLightBox(testLightBox, new int[] {0,1,2,3,4});

        //Client reserved all content of LightBox
        reservation.addAllPicturesFromLightBox(testLightBox);

        //Test reservation - is have not contain duplicate Pictures!
        System.out.println(reservation.toString());


        Offer offer = reservation.generateOffer();

        client.agreeOffer(offer);

        if (offer.isAgreeByClient())
            client.charge(offer.getTotalCost(), "For Pictures");

        Purchase purchase = new Purchase(client, offer.getItems());


    }

}
