package warehouse;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        // StdIn.setFile("addproduct.out");
        // StdOut.setFile("addproduct.out");
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        int n = StdIn.readInt();
        for(int i = 0; i < n; i++)
        {
            int day = StdIn.readInt();;
            int id = StdIn.readInt();
            String productName = StdIn.readString();
            int initialItemStock =  StdIn.readInt();
            int initialitemDemand = StdIn.readInt();    
            w.addProduct(id, productName, initialItemStock, day, initialitemDemand);
        } 
        System.out.println(w);
	// Use this file to test addProduct
    // System.out.println(newWarehouse.getSectors()[2]);
    }
}
