package pl.com.bottega.photostock.sales.model.users;

import pl.com.bottega.photostock.sales.model.deal.Offer;
import pl.com.bottega.photostock.sales.model.user_tool.LightBox;
import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static pl.com.bottega.photostock.sales.model.common.CurrencyConverter.convertUSDToCradit;

/**
 * Created by Slawek on 12/03/16.
 */
public class Client {

    private String name;
    private String address;
    private boolean isVip;
    private double debt;
    private double amount;
    private double creditLimit;
    private boolean active = true;
    private List<LightBox> lightboxes = new ArrayList();
    private List<Client> colleagues = new ArrayList();





    public Client(String name, String address, boolean isVip, double debt, double amount, double creditLimit) {
        this.name = name;
        this.address = address;
        this.isVip = isVip;
        this.debt = debt;
        this.amount = amount;
        this.creditLimit = creditLimit;
    }

    public Client(String name, String address, double creditLimit) {
        this(name, address, false, 0, 0, creditLimit);
    }


    public void addLightBox(LightBox lightBoxToAdd) {
        lightboxes.add(lightBoxToAdd);
    }

    public String printLightboxesContent() {
        StringBuilder s = new StringBuilder();
        for (LightBox lbx : lightboxes) {
            s.append(lbx.toString());
        }
        return s.toString();
    }

    public LightBox getCommonLightBox(){
        Set<Picture> uniqPictLB = new HashSet<Picture>();
        LightBox result = new LightBox(this);
        for (LightBox lbx : lightboxes) {
            for (Picture pic : lbx.getPictures()) {
                if(!uniqPictLB.contains(pic))
                    uniqPictLB.add(pic);
            }
        }
        for (Picture pic : uniqPictLB) {
            result.add(pic);
        }
        return result;
    }

    public void sendMyLightBox(LightBox lightBoxToShare){

    }

    public LightBox createLightBox(String lightBoxName) {
        LightBox lbx = new LightBox(this, lightBoxName);
        addLightBox(lbx);
        return lbx;
    }

    public boolean canAfford(double offerAmount) {
        if (isVip) {
            if (amount > 0)
                return amount + creditLimit >= offerAmount;
            else
                return creditLimit >= offerAmount;
        } else
            return amount >= offerAmount;
    }

    public String getName() {
        return name;
    }

    public void charge(double offerAmount, String cause) {
        if (this.canAfford(offerAmount)) {
            if (amount >= offerAmount)
                this.amount -= offerAmount;
            else {
                changeDebt(offerAmount- amount);
                changeCreditLimit(creditLimit - debt);
                changeAmount(0);
            }
        } else
            System.out.println("Doładuj konto!");
    }

    public void recharge(double realMoney) {
        double quantity = convertUSDToCradit(realMoney);
        this.debt -= quantity;
        if (this.debt < 0) {
            this.amount -= this.debt;
            this.debt = 0;
        }
    }

    public double getSaldo() {
        return amount - debt;
    }

    public boolean isActive() {
        return active;
    }

    private void changeDebt(double debt) {
        this.debt = debt;
    }

    private void changeAmount(double finalAmount) {
        this.amount = finalAmount;
    }

    private void changeCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }


    public void getAllInfo() {
        System.out.printf("\nName - %s\nAddress - %s\nVIP - %b\nDebt - %g\nAmount - %g\nCreditlimit - %g\n", name, address, isVip, debt, amount, creditLimit);
    }

    public void shareLightBox(LightBox sharedLightBox, Client colleague) {
         colleague.addLightBox(sharedLightBox);
    }

    public void agreeOffer(Offer offerToAgree) {
        offerToAgree.setAgreeByClient(true);
    }
}