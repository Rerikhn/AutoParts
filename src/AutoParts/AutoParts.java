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
        ///....
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
        if (availableSpace <= 0) System.err.println("Error, value must be more than zero.");
        else
            this.availableSpace = availableSpace;
    }

    public void setDimension(String dimension) {
        /*if (dimension.length() < 11) System.err.println("Error, size is not compatible.");
        else*/
        this.dimension = dimension;
    }

    public void setPrice(float price) {
        if (price <= 0) System.err.println("Error, value must be more than zero.");
        else
            this.price = price;
    }

    public void setVendor(String vendor) {
        if (vendor.isEmpty()) System.err.println("Error, is empty.");
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

    public void sortAscending(ArrayList<AutoParts> list, String str) { //сортировка по возрастанию по полю "Габариты"
        ArrayList<AutoParts> temp = new ArrayList<>();
        //проверка на совпадение со строкой Vendor
        for (int i = 0; i < list.size(); i++) {
            if (str.equalsIgnoreCase(list.get(i).getVendor())) {
                temp.add(list.get(i));
            } else System.err.println("\nError, cant find this vendor!\n");
        }
        Collections.sort(temp, new Comparator<AutoParts>() {
            @Override //переопределение метода
            public int compare(AutoParts v1, AutoParts v2) {
                return v1.getDimension().substring(4, 7).compareTo(v2.getDimension().substring(4, 7));
            }
        });
        System.out.println("Sorted list by Vendor: ");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println("\nVendor: " + temp.get(i).getVendor()
                    + "\nDimension: " + temp.get(i).getDimension()
                    + "\nPrice: " + temp.get(i).getPrice();
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
        ArrayList <AutoParts> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String strTemp1 = list.get(i).getDimension().replaceAll("[-]", "");
            String strTemp2 = str.replaceAll("[-]", "");
            if (Integer.parseInt(strTemp1) <= Integer.parseInt(strTemp2)) {
                temp.add(list.get(i));
            } else if (list.get(i).getPrice() > list.get(i + 1).getPrice()) {
                temp.add(list.get(i));
            }
        }
        System.out.println("Sorted list by most rich part: ");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println("\nVendor: " + temp.get(i).getVendor()
                    + "\nDimension: " + temp.get(i).getDimension()
                    + "\nPrice: " + temp.get(i).getPrice();
                    + "\nAvailable count: " + temp.get(i).getAvailableSpace());
        }
    }

/**TODO//
 DONE  1) Ascending sort by 3rd block of dimension;
 DONE  2) Finding parts by Vendor name;
 DONE 3) public void mostRichPart () {
 }*/
}
