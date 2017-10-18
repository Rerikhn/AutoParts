package AutoParts;

import java.util.*;

public class AutoPartsMain {

    public static void main(String[] args) {

        AutoParts Parts = new AutoParts();
        ArrayList<AutoParts> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Parts.userMenu();
        while (true) {
            switch (scan.nextLine()) {
                case "add": {
                    System.err.println("How many parts? ");
                    int n = scan.nextInt();
                    if (n > 0)
                        for (int i = 0; i < n; i++) {
                            System.err.println("\nSet Vendor: ");
                            Parts.setVendor(scan.next());
                            System.err.println("Set Price: ");
                            Parts.setPrice(scan.nextFloat());
                            System.err.println("Set available space: ");
                            Parts.setAvailableSpace(scan.nextInt());
                            System.err.println("Set size of part ( format: NNN-NNN-NNN )");
                            Parts.setDimension(scan.next());
                            list.add(i, new AutoParts(Parts));
                        }
                    else System.err.println("Error, value must be more than zero! ");
                    Parts.userMenu();
                    break;
                }
                case "print": {
                    if (list.size() != 0) {
                        Parts.viewList(list);
                    } else {
                        System.err.println("\nList is empty!");
                    }
                    break;
                }
                case "sortVendor": {
                    System.err.println("Set name Vendor: ");
                    Parts.sortAscending(list, scan.next());
                    System.err.println("Done.");
                    Parts.userMenu();
                    break;
                }
                case "mostRich": {
                    System.err.println("Set dimensions: ");
                    Parts.mostRich(list, scan.next());
                    System.err.println("Done.");
                    Parts.viewList(list);
                    break;
                }
                case "exit":
                    System.exit(0);
                default:
                    System.err.println("Error, type correct command!\n");
                    break;
            }
        }
    }
}
