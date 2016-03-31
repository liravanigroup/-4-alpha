package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.users.Client;

/**
 * Created by Slawek on 13/03/16.
 */
public class ClientTestConsoleApp {
    public static void main(String[] args) {
        Client client = new Client("Janusz", "Lublin", false, 4, 10, 20);

        // client entry: `cats`, `dogs`, `cars`;

        //Get pictures by client query

        //Show list of pictures on a Display

//        Picture cat1 = new Picture("nrCAT000125", "My_Black_Cat", 111, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat2 = new Picture("nrCAT000125", "My_Black_Cat", 122, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat3 = new Picture("nrCAT000125", "My_Black_Cat", 125, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat4 = new Picture("nrCAT000125", "My_Black_Cat", 128, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat5 = new Picture("nrCAT000125", "My_Black_Cat", 127, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat6 = new Picture("nrCAT000125", "My_Black_Cat", 125, new String[]{"cat", "black_cat", "my_cat"}, true);
//        Picture cat7 = new Picture("nrCAT000125", "My_Black_Cat", 126, new String[]{"cat", "black_cat", "my_cat"}, true);
//
//        Picture dog1 = new Picture("nrDG050321", "My_Black_Dog", 52, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog2 = new Picture("nrDG050322", "My_Black_Dog", 22, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog3 = new Picture("nrDG050323", "My_Black_Dog", 12, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog4 = new Picture("nrDG050325", "My_Black_Dog", 32, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog5 = new Picture("nrDG050324", "My_Black_Dog", 12, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog6 = new Picture("nrDG050326", "My_Black_Dog", 52, new String[]{"dog", "black_dog", "my_dog"}, true);
//        Picture dog7 = new Picture("nrDG050328", "My_Black_Dog", 72, new String[]{"dog", "black_dog", "my_dog"}, true);
//
//        Picture car1 = new Picture("nrC000125", "My_Black_CAR", 82, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car2 = new Picture("nrC000126", "My_Black_CAR", 2, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car3 = new Picture("nrC000127", "My_Black_CAR", 11, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car4 = new Picture("nrC000128", "My_Black_CAR", 18, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car5 = new Picture("nrC000129", "My_Black_CAR", 16, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car6 = new Picture("nrC000124", "My_Black_CAR", 18, new String[]{"car", "black_car", "my_car"}, true);
//        Picture car7 = new Picture("nrC000123", "My_Black_CAR", 13, new String[]{"car", "black_car", "my_car"}, true);
//
//        Picture rcar1 = new Picture("nrC030125", "My_race_CAR", 182, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//        Picture rcar2 = new Picture("nrC030126", "My_race_CAR", 12, new String[]{"crar", "black_crar", "my_crar"}, true);
//        Picture rcar3 = new Picture("nrC030127", "My_race_CAR", 111, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//        Picture rcar4 = new Picture("nrC030128", "My_race_CAR", 118, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//        Picture rcar5 = new Picture("nrC030129", "My_race_CAR", 116, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//        Picture rcar6 = new Picture("nrC030124", "My_race_CAR", 118, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//        Picture rcar7 = new Picture("nrC030123", "My_race_CAR", 113, new String[]{"rcar", "black_rcar", "my_rcar"}, true);
//
//
//
//        LightBox catsLightBox = client.createLightBox("Cats");
//        catsLightBox.add(cat1);
//        catsLightBox.add(cat2);
//        catsLightBox.add(cat3);
//        catsLightBox.add(cat4);
//        catsLightBox.add(cat5);
//        catsLightBox.add(cat6);
//        catsLightBox.add(cat7);
//        catsLightBox.add(rcar1);
//        catsLightBox.add(rcar2);
//        catsLightBox.add(rcar3);
//        catsLightBox.add(rcar4);
//        catsLightBox.add(rcar5);
//        catsLightBox.add(rcar6);
//        catsLightBox.add(rcar7);
//
//
//
//        LightBox dogsLightBox = client.createLightBox("Dogs");
//        dogsLightBox.add(dog1);
//        dogsLightBox.add(dog2);
//        dogsLightBox.add(dog3);
//        dogsLightBox.add(dog4);
//        dogsLightBox.add(dog5);
//        dogsLightBox.add(dog6);
//        dogsLightBox.add(dog7);
//        dogsLightBox.add(rcar1);
//        dogsLightBox.add(rcar2);
//        dogsLightBox.add(rcar3);
//        dogsLightBox.add(rcar4);
//        dogsLightBox.add(rcar5);
//        dogsLightBox.add(rcar6);
//        dogsLightBox.add(rcar7);
//
//
//
//        LightBox carsLightBox = client.createLightBox("Cars");
//        carsLightBox.add(car1);
//        carsLightBox.add(car2);
//        carsLightBox.add(car3);
//        carsLightBox.add(car4);
//        carsLightBox.add(car5);
//        carsLightBox.add(car6);
//        carsLightBox.add(car7);
//        carsLightBox.add(rcar1);
//        carsLightBox.add(rcar2);
//        carsLightBox.add(rcar3);
//        carsLightBox.add(rcar4);
//        carsLightBox.add(rcar5);
//        carsLightBox.add(rcar6);
//        carsLightBox.add(rcar7);
//
//
//        client.sendMyLightBox(carsLightBox);
//
//
//        Reservation reservation = new Reservation(client);
//
////        reservation.add(car1);
////        reservation.add(cat2);
////        reservation.add(dog3);
////        reservation.add(car4);
////        reservation.add(rcar5);
////        reservation.add(car6);
////        reservation.add(rcar7);
//
//       reservation.addAllPicturesFromLightBox(dogsLightBox);
//
//       System.out.println(reservation.toString());
//
//
////        panJanusz.recharge(10);
////        if (panJanusz.canAfford(12)) {
////            panJanusz.charge(12, "za coś");
////            System.out.println("Saldo: " + panJanusz.getSaldo());
////        } else {
////            System.out.println("can not afford!");
////        }
    }
}
