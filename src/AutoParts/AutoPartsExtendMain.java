package AutoParts;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoPartsExtendMain {
    public static void main(String[] args) {
        AutoPartsExtend Parts = new AutoPartsExtend();
        ArrayList<AutoPartsExtend> list = new ArrayList<>();
        System.err.println("How many parts? ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.err.println("\nSet Vendor: ");
            Parts.setVendor(scan.next());
            System.err.println("Set Price: ");
            Parts.setPrice(scan.nextFloat());
            System.err.println("Set available space: ");
            Parts.setAvailableSpace(scan.nextInt());
            System.err.println("Set size of part ( format: NNN-NNN-NNN )");
            Parts.setDimension(scan.next());
            System.err.println("Set durability: ");
            Parts.setDurability(scan.nextInt());
            list.add(i, new AutoPartsExtend(Parts));
        }
        Parts.sortDurability(list);
    }
}
