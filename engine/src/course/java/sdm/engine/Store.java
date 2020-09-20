package course.java.sdm.engine;
import generatedClasses.SDMDiscount;
import generatedClasses.SDMSell;
import generatedClasses.SDMStore;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
import java.util.*;
import java.util.List;

@XmlRootElement(name = "SDM-store")
public class Store {
    private int serialNumber;
    private String name;
    private Map<Integer,Integer> productPrices = new HashMap<>();//serial price
    private Map<Integer,Float> productsSold = new HashMap<>(); //serial total earnings
    private List<Order> orders = new ArrayList<>();
    private List<Discount> discounts =  new ArrayList<>();
    private int PPK;
    private float deliveryEarnings;
    private Point location;

    public Store(){}

    public Store(SDMStore store){
        serialNumber = store.getId();
        name = store.getName();
        for(SDMSell sell : store.getSDMPrices().getSDMSell()){
            productPrices.put(sell.getItemId(), sell.getPrice());
            productsSold.put(sell.getItemId(),0f);
        }
        if(store.getSDMDiscounts() !=null)
            for(SDMDiscount discount: store.getSDMDiscounts().getSDMDiscount()) {
               discounts.add(new Discount(discount));
            }
        PPK = store.getDeliveryPpk();
        location = new Point(store.getLocation().getX(),store.getLocation().getY());

    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getPPK() {
        return PPK;
    }

    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeliveryEarnings(float deliveryEarnings) {
        this.deliveryEarnings = deliveryEarnings;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setPPK(int PPK) {
        this.PPK = PPK;
    }

    public void setProductsSold(Map.Entry<Integer, Float> productsSold) {
        this.productsSold.put(productsSold.getKey(), this.productsSold.get(productsSold.getKey()) + productsSold.getValue());
    }

    public Map<Integer, Integer> getProductPrices() {
        return productPrices;
    }

    public Map<Integer, Float> getProductsSold() {
        return productsSold;
    }

    public void deleteProduct(int chosenProductSerial) {
        productPrices.remove(chosenProductSerial);
        productsSold.remove(chosenProductSerial);
    }

    public String printStore(Map<Integer, Product> allProducts) {
        int i = 1;
        String res = "--------------------" +
                "\nSerialNumber: " + serialNumber +
                "\nName: " + name +
                "\nList of products:";

        for(Map.Entry<Integer, Integer> product : productPrices.entrySet()){
            res += "\n  " + i++ + ". " + (allProducts.get(product.getKey()).getName()) +  "\n     price: "+(product.getValue().toString()) +
            "\n     amount sold: " + (productsSold.get(product.getKey()));
        }
        res = res + "\norders:" + (orders.size() > 0 ? orders : " none") +
                "\nPPK: " + PPK +
                "\ndeliveryEarnings: " + deliveryEarnings;

        return res;
    }


}
