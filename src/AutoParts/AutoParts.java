package AutoParts;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class AutoParts {
    private String vendor;
    private String dimension;
    private float price;
    private int availableSpace;

    public AutoParts(String vendor, String dimension, float price, int availableSpace) {
        this.vendor = vendor;
        this.price = price;
        this.availableSpace = availableSpace;
        this.dimension = dimension;
    }

    public AutoParts(AutoParts obj) {
        this(obj.getVendor(), obj.getDimension(), obj.getPrice(), obj.getAvailableSpace());
    }

    public AutoParts() {
    }

    public String getVendor() {
        return vendor;
    }

    public float getPrice() {
        return price;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public String getDimension() {
        return dimension;
    }

    public void setAvailableSpace(int availableSpace) {
        if (availableSpace <= 0) System.err.println("Error, value cannot be negative.");
        else
            this.availableSpace = availableSpace;
    }

    public void setDimension(String dimension) {
        if (dimension.length() < 11 | dimension.isEmpty()) System.err.println("Error format.");
        else
            this.dimension = dimension;
    }

    public void setPrice(float price) {
        if (price <= 0) System.err.println("Error, value cannot be negative.");
        else
            this.price = price;
    }

    public void setVendor(String vendor) {
        if (vendor.isEmpty()) System.err.println("Error, cannot be empty.");
        else
            this.vendor = vendor;
    }

    public void viewList(ArrayList<AutoParts> tempList) {
        for (int i = 0; i < tempList.size(); i++) {
            System.out.println("\n\nAuto Part: " + (i + 1)
                    + "\nVendor: " + tempList.get(i).getVendor()
                    + "\nDimension: " + tempList.get(i).getDimension()
                    + "\nPrice: " + tempList.get(i).getPrice()
                    + "\nAvailable count: " + tempList.get(i).getAvailableSpace());
        }
    }

    public void sortAscending(ArrayList<AutoParts> list, String str) {
        ArrayList<AutoParts> temp = new ArrayList<>();
        //проверка на совпадение со строкой Vendor
        for (int i = 0; i < list.size(); i++) {
            if (str.equalsIgnoreCase(list.get(i).getVendor())) {
                temp.add(list.get(i));
            }
        }
        Collections.sort(temp, new Comparator<AutoParts>() {
            @Override
            public int compare(AutoParts v1, AutoParts v2) {
                //сравнение по второму блоку "Габаритов"
                return v1.getDimension().substring(4, 7).compareTo(v2.getDimension().substring(4, 7));
            }
        });
        System.out.println("\nShowing list of " + str + "parts sorted by ascending of dimensions:");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println("\nVendor: " + temp.get(i).getVendor()
                    + "\nDimension: " + temp.get(i).getDimension()
                    + "\nPrice: " + temp.get(i).getPrice()
                    + "\nAvailable count: " + temp.get(i).getAvailableSpace());
        }
    }

    public void userMenu() {
        System.out.println("\nEnter the key... " +
                "\nType\"add\"to add new auto part." +
                "\nType\"print\" to view all list." +
                "\nType\"sortVendor\" to sort parts by ascending of dimension." +
                "\nType\"mostRich\" to sort parts by price." +
                "\nType\"exit\"to exit the program.\n");
    }

    public void mostRich(ArrayList<AutoParts> list, String str) {
        ArrayList<AutoParts> temp = new ArrayList<>();
        String strTemp1 = str.replaceAll("[-]", "");
        System.out.println("Sorted list by most rich part: ");
        for (int i = 0; i < list.size(); i++) {
            String strTemp2 = list.get(i).getDimension().replaceAll("[-]", "");
            if (Integer.parseInt(strTemp1) >= Integer.parseInt(strTemp2))
                temp.add(list.get(i));
        }
        Collections.sort(temp, new Comparator<AutoParts>() {
            @Override
            public int compare(AutoParts v1, AutoParts v2) {
                return Float.compare(v2.getPrice(), v1.getPrice());
            }
        });
        //for java 8
        //Collections.sort(temp, Comparator.comparing(AutoParts::getPrice));
        //for (int i = 0; i < temp.size(); i++) {
        //if (temp.get(i).getPrice() < temp.get(i + 1).getPrice()) {
        System.out.println("\nVendor: " + temp.get(0).getVendor()
                + "\nDimension: " + temp.get(0).getDimension()
                + "\nPrice: " + temp.get(0).getPrice()
                + "\nAvailable count: " + temp.get(0).getAvailableSpace());
        //}
        //}
    }

/**TODO//
 DONE  1) Ascending sort by 3rd block of dimension;
 DONE  2) Finding parts by Vendor name and sort by most rich price;
 DONE 3) public void mostRichPart () {
 }*/
}
