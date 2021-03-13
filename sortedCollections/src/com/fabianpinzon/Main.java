package com.fabianpinzon;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	   StockItem temp = new StockItem("Antena wifi", 19900, 20);
        stockList.addStock(temp);

        temp = new StockItem("Mini cámara espia", 34900, 5);
        stockList.addStock(temp);

        temp = new StockItem("Trípode flexible", 11900, 30);
        stockList.addStock(temp);

        temp = new StockItem("Repetidor wifi", 93900, 10);
        stockList.addStock(temp);

        temp = new StockItem("Báscula", 29900, 15);
        stockList.addStock(temp);

        temp = new StockItem("Gramera", 28900, 23);
        stockList.addStock(temp);
        temp = new StockItem("Gramera", 28900, 7);
        stockList.addStock(temp);

        temp = new StockItem("Cámara web usb", 59900, 7);
        stockList.addStock(temp);

        temp = new StockItem("Detector cámara espia", 89900, 2);
        stockList.addStock(temp);

        temp = new StockItem("Traductor idiomas", 229900, 2);
        stockList.addStock(temp);

        temp = new StockItem("Carcasa", 33900, 50);
        stockList.addStock(temp);

        System.out.println(stockList);

        System.out.println("\nItems in stock:");
        for(String s : stockList.items().keySet()){
            System.out.println(s);
        }
        System.out.println("\nItems with their price:");
        for(Map.Entry<String, Integer> price : stockList.PricesList().entrySet()){
            System.out.println(price.getKey() + " -  Price: " + price.getValue()  );
        }

        Basket fabiansBasket = new Basket("Fabian");

        sellItem(fabiansBasket, "Detector cámara espia", 1);
        sellItem(fabiansBasket, "Detector cámara espia", 1);

        if(sellItem(fabiansBasket, "Detector cámara espia", 1) == 0){
            System.out.println("\nItem: Detector cámara espia is out of stock");
        }
        sellItem(fabiansBasket, "Pitbull", 1);

        sellItem(fabiansBasket, "Traductor idiomas", 1);
        sellItem(fabiansBasket, "Carcasa", 2);
        sellItem(fabiansBasket, "Antena wifi", 2);
        System.out.println(fabiansBasket);

        /*temp = new StockItem("Bicicleta", 220000);
        stockList.items().put(temp.getName(), temp);*/

        Basket momBasket = new Basket("Mom");
        sellItem(momBasket, "Gramera", 30);
        sellItem(momBasket, "Carcasa", 3);
        removeItem(momBasket, "Gramera", 1);
        //sellItem(momBasket, "Gramera", 1);
        System.out.println(stockList.items().get("Gramera"));
        System.out.println(momBasket);


        removeItem(fabiansBasket, "Detector cámara espia", 1);
        removeItem(fabiansBasket, "Antena wifi", 2);
        removeItem(fabiansBasket, "Detector cámara espia", 1);
        removeItem(fabiansBasket, "Carcasa", 2);
        removeItem(fabiansBasket, "Traductor idiomas", 1);

        System.out.println("Detector cámara espia removed: " + removeItem(fabiansBasket, "Detector cámara espia", 1));// should not remove any

        System.out.println(fabiansBasket);

        StockItem webCam = stockList.items().get("Cámara web usb");
        if(webCam != null){
            stockList.items().get("Cámara web usb").adjustStock(2000);
        }
        if(webCam != null){
            stockList.get("Cámara web usb").adjustStock(-1000);
        }


        //remove all items from fabian's basket


        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(momBasket);
        System.out.println(stockList);
        checkout(momBasket);
        System.out.println(momBasket);
        System.out.println(stockList);

        checkout(fabiansBasket);
        System.out.println(fabiansBasket);

    }



    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("\nWe don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        //retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("\nWe don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkout(Basket basket){
        for(Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }


}
