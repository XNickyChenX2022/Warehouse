package warehouse;

/*
 * Use this class to put it all together.
 */ 
public class Everything {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        int n = StdIn.readInt();
        for(int i = 0; i < n; i++)
        {
            String query = StdIn.readString();
            if (query.equals("add"))
            {
                int day = StdIn.readInt();;
                int id = StdIn.readInt();
                String productName = StdIn.readString();
                int initialItemStock =  StdIn.readInt();
                int initialitemDemand = StdIn.readInt();    
                w.addProduct(id, productName, initialItemStock, day, initialitemDemand);
            }  
            else if (query.equals("delete"))
            {
                int id = StdIn.readInt();
                w.deleteProduct(id);
            }
            else if (query.equals("purchase"))
            {
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                int amount = StdIn.readInt();
                w.purchaseProduct(id, day, amount);            
            }
            else
            {
                int id = StdIn.readInt();
                int amount = StdIn.readInt();
                w.restockProduct(id, amount);
            }
        }
        StdOut.println(w);
	// Use this file to test all methods
    }
}
