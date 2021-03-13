package com.fabianpinzon;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private int price;
    private int quantityInStock = 0; // can be initialized later
    private int reserved = 0;

    public StockItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0; // or here(but you wouldn't normally do both)
    }

    public StockItem(String name, int price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void setPrice(int price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity >= 0){
            this.quantityInStock = newQuantity;
        }
    }

    public int reserveStock(int quantity){
        if(quantity <= availableQuantity()){
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        if(this == o) {
            return 0;
        }
        if(o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + "\nPrice: " + "$" +  this.price + " - Quantity : " + this.quantityInStock + " - Reserved : " + reserved + "\n";
    }
}