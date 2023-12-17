package warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile("purchaseproduct.in");
        StdOut.setFile("purchaseproduct.out");
        Warehouse w = new Warehouse();
        int n = StdIn.readInt();
        for(int i = 0; i < n; i++)
        {
            String query = StdIn.readString();
            if(query.equals("add"))
            {
                int day = StdIn.readInt();;
                int id = StdIn.readInt();
                String productName = StdIn.readString();
                int initialItemStock =  StdIn.readInt();
                int initialitemDemand = StdIn.readInt();    
                w.addProduct(id, productName, initialItemStock, day, initialitemDemand);
            }
            else
            {
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                int amount = StdIn.readInt();
                w.purchaseProduct(id, day, amount);            
            }

        }
        StdOut.println(w);
	// Use this file to test purchaseProduct
    }
}
