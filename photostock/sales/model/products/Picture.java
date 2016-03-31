package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.common.Resolution;
import pl.com.bottega.photostock.sales.model.users.Client;

import java.util.ArrayList;
import java.util.List;


public class Picture implements Cloneable {

    private String number;
    private String name;
    private String[] tags;
    private boolean isAvailabe;
    private List<Resolution> resolutions = new ArrayList<Resolution>();
    private String maxResolution;


    public Picture(String number, String name, String[] tags, boolean isAvailabe, String maxResolution, List<Resolution> resolutions) {
        this.number = number;
        this.name = name;
        this.tags = tags;
        this.isAvailabe = isAvailabe;
        this.maxResolution = maxResolution;
        this.resolutions = resolutions;
    }

    public String getMaxResolution() {
        return maxResolution;
    }
    @Override
    public Picture clone(){
        return new Picture(number,name,tags,isAvailabe,maxResolution,resolutions);
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }



    public double calculatePrice() {
        return 0; //TODO dodac alg wyliczania
    }

    public void reservedPer(Client reservingClient) {

    }

    public void unreservedPer(Client unreservigClient) {

    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailabe;
    }

    public void cancel() {
        isAvailabe = false;
    }

    public String getNumber() {
        return number;
    }


    public Picture getBoughtStain() {
        this.isAvailabe = false;
        return this;
    }


}
