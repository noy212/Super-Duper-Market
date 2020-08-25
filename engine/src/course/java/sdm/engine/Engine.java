package course.java.sdm.engine;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

import generatedClasses.*;

public class Engine {
    private static int orderNum = 0;
    private Map<Integer, Product> allProducts;
    private Map<Integer, Store> allStores;
    private boolean isXMLLoaded = false;
    private SuperXML superXML = new SuperXML();
    private List<Order> orders = new ArrayList<>();

    public void loadXML(String filePath) throws Exception {
        try {
            superXML.load(filePath);
            initMembers();
            isXMLLoaded = true;
        }
        catch (Exception e){
            throw e;
        }
    }

    public boolean getisXMLLoaded() {
        return isXMLLoaded;
    }

    public void initMembers(){
        allProducts = superXML.getTempAllProducts();
        allStores = superXML.getTempAllStores();
        setProductAvgAndStoreCount();
    }

    private void setProductAvgAndStoreCount() {
        int price = 0;
        for(Product product : allProducts.values()){
            price = 0;
            for(Store store : allStores.values()){
                if(store.getProductPrices().containsKey(product.getSerialNumber())) {
                    price += store.getProductPrices().get(product.getSerialNumber());
                    product.setStoreCount();
                }
            }
            product.setAvgPrice(price);
        }
    }

    public void executeCommand() {
    }

    public Map<Integer, Product> getProducts() {
        return allProducts;
    }
    public Map<Integer, Store> getStores() {
        return allStores;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order setNewOrder(Store chosenStore, Date deliveryDate, Map<Integer, Float> productsToOrder, Point customerLocation) {
        Order newOrder = new Order(++orderNum,deliveryDate, productsToOrder, customerLocation);
        newOrder.updateStoreProducts(chosenStore.getSerialNumber());
        newOrder.calculateDistance(allStores);
        return newOrder;
    }

    public void addOrder(Order newOrder) {
        newOrder.calculatePrice(allStores);
        newOrder.calculateTotalPrice();
        updateProductSoldAmount(newOrder);
        orders.add(newOrder);
    }

    private void updateProductSoldAmount(Order newOrder) {
        for(Map<Integer, Float> soldProduct : newOrder.getStoreProducts().values()){
            for(Map.Entry <Integer, Float> productSerial : soldProduct.entrySet()){
                allProducts.get(productSerial.getKey()).setSoldAmount(soldProduct.get(productSerial.getKey()));
            }
        }
    }
}
