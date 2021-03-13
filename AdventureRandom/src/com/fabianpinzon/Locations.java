package com.fabianpinzon;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        System.out.println("main Locations.java");
        /*try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locFile.writeObject(location);
            }
        }*/
        try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
            rao.writeInt(locations.size());
            System.out.println(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            System.out.println("Integer.BYTES " + Integer.BYTES);
            System.out.println("indexSize " + indexSize);
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            System.out.println("rao.getFilePointer() " + rao.getFilePointer());
            System.out.println("locationStart " + locationStart);
            rao.writeInt(locationStart);
            long indexStart = rao.getFilePointer();
            System.out.println("indexStart " + indexStart);
            int startPointer = locationStart;
            System.out.println(startPointer);
            rao.seek(startPointer);

            for(Location location: locations.values()){
                rao.writeInt(location.getLocationId());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                System.out.println(builder.toString());
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationId(), record);
                System.out.println("(int) rao.getFilePointer() " + (int) rao.getFilePointer());
                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);
            for(Integer locationId : index.keySet()){
                rao.writeInt(locationId);
                System.out.println("index.get(locationId).getStartByte() : " + index.get(locationId).getStartByte());
                System.out.println("index.get(locationId).getLength() " + index.get(locationId).getLength());
                rao.writeInt(index.get(locationId).getStartByte());
                rao.writeInt(index.get(locationId).getLength());
            }
        }
    }

    //1. The first 4 bytes will contain the number of locations (bytes 0-3)
    //2. The next 4 bytes will contain the start offset of the location section (bytes 4-7)
    //3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699)
    //4. The final section of the file will contain the location records (the data). It will start at byte 1700

    static{
        System.out.println("static");

        try{
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            System.out.println("numLocations: " + numLocations);
            long locationStartPoint = ra.readInt();
            System.out.println("locationStartPoint: " + locationStartPoint);
            System.out.println("ra.getFilePointer(): " + ra.getFilePointer());
            while(ra.getFilePointer() < locationStartPoint){
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        }catch(IOException e){
            System.out.println("IOException in static initializer " + e.getMessage());
        }

 /*      try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
           boolean eof = false;
           while (!eof) {
               try {
                   Location location = (Location) locFile.readObject();
                   System.out.println(location.getLocationId() + ": " + location.getDescription());
                   System.out.println("Found " + location.getExits().size() + " exits");
                   locations.put(location.getLocationId(), location);
               } catch (EOFException e) {                    eof = true;
               }
           }
       }catch (InvalidClassException e){
           System.out.println("InvalidClassException " + e.getMessage());
       }catch (IOException io){
           System.out.println("IO Exception " + io.getMessage());
       }catch (ClassNotFoundException e){
           System.out.println("ClassNotFoundException " + e.getMessage());
       }*/
    }

    public Location getLocation(int locationId) throws IOException{

        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        System.out.println("id: " + id);
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");
        System.out.println("exits: " + exits);
        System.out.println(Arrays.toString(exitPart));

        Location location = new Location(locationId, description, null);
        if(locationId != 0){
            for (int i = 0; i< exitPart.length; i++){
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                System.out.println("destination: " + destination);
                location.addExit(direction, destination);
            }
        }
        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException{
        ra.close();
    }
}
