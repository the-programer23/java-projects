package com.fabianpinzon;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();
    //To organize the seat prices in an ascending order
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                System.out.println(seat1.getSeatNumber());
                System.out.println(seat2.getSeatNumber());
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        //'A' is equals to 65
        //int lastRow = 'H' is equals to 72
        int lastRow = 'A' + (numRows - 1); // 72
        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4) && (seatNum <= 9)){
                    price = 14.00;
                }else if((row > 'F') || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestSeat = new Seat(seatNumber, 0);
        //using Collections.binarySearch is more efficient (it takes less iterations) than a for loop
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);

        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

       /* for(Seat seat: seats){
            System.out.print(".");
            if(seat.getSeatNumber().equals(seatNumber)){
                requestSeat = seat;
                break;
            }
        }
        if(requestSeat == null){
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
        return requestSeat.reserve();*/
    }

    //for testing
    public Collection<Seat> getSeats(){
        return seats;
    }


    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

       @Override
        public int compareTo(Seat seat) {
            //This returns the position of the seat in the list if the seat passed to compareTo is in the List
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!reserved){
                reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }else {
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " canceled");
                return true;
            }else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }


}
