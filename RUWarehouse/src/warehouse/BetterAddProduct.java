package warehouse;

/*
 * Use this class to test the betterAddProduct method.
 */ 
public class BetterAddProduct {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        StdIn.setFile("betteraddproduct.in");
        StdOut.setFile("betteraddproduct.out");
        int n = StdIn.readInt();
        for(int i = 0; i < n; i++)
        {
            int day = StdIn.readInt();
            int id = StdIn.readInt();
            String productName = StdIn.readString();
            int initialItemStock =  StdIn.readInt();
            int initialitemDemand = StdIn.readInt();    
            w.betterAddProduct(id, productName, initialItemStock, day, initialitemDemand);
        } 
        StdOut.println(w);
	// Use this file to test addProduct
    // System.out.println(newWarehouse.getSectors()[2]);
        // Use this file to test betterAddProduct
    }
}
