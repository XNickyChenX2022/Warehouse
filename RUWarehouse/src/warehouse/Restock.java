package warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);
        Warehouse w = new Warehouse();
        int  n = StdIn.readInt();
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
                int amount = StdIn.readInt();
                w.restockProduct(id, amount);
            }

        }
        StdOut.println(w);
	// Uset his file to test restock
    }
}
