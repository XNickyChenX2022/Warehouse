package warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
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
               int id = StdIn.readInt();
               w.deleteProduct(id);
            }

        }
        StdOut.println(w);
	// Use this file to test deleteProduct
    }
}
