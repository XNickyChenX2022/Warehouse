package warehouse;

import java.nio.file.AtomicMoveNotSupportedException;

/*
 *
 * This class implements a warehouse on a Hash Table like structure, 
 * where each entry of the table stores a priority queue. 
 * Due to your limited space, you are unable to simply rehash to get more space. 
 * However, you can use your priority queue structure to delete less popular items 
 * and keep the space constant.
 * 
 * @author Ishaan Ivaturi
 */ 
public class Warehouse {
    private Sector[] sectors;
    
    // Initializes every sector to an empty sector
    public Warehouse() {
        sectors = new Sector[10];

        for (int i = 0; i < 10; i++) {
            sectors[i] = new Sector();
        }
    }
    
    /**
     * Provided method, code the parts to add their behavior
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void addProduct(int id, String name, int stock, int day, int demand) {
        evictIfNeeded(id);
        addToEnd(id, name, stock, day, demand);
        fixHeap(id);
    }

    /**
     * Add a new product to the end of the correct sector
     * Requires proper use of the .add() method in the Sector class
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    private void addToEnd(int id, String name, int stock, int day, int demand) {
        int i = id % 10;
        Product newProduct = new Product(id, name, stock, day, demand);
        sectors[i].add(newProduct);
    }
    //       

    /**
     * Fix the heap structure of the sector, assuming the item was already added
     * Requires proper use of the .swim() and .getSize() methods in the Sector class
     * @param id The id of the item which was added
     */
    private void fixHeap(int id) {
        int i = id % 10;
        int sectorSize = sectors[i].getSize();
        sectors[i].swim(sectorSize);
        
        
        // IMPLEMENT THIS METHOD
    }

    /**
     * Delete the least popular item in the correct sector, only if its size is 5 while maintaining heap
     * Requires proper use of the .swap(), .deleteLast(), and .sink() methods in the Sector class
     * @param id The id of the item which is about to be added
     */
    private void evictIfNeeded(int id) {
        int i = id % 10;
        int sectorSize = sectors[i].getSize();
        Sector currentSector = sectors[i];
        if(sectorSize == 5)
        {
            currentSector.swap(1, 5);
            currentSector.deleteLast();
            currentSector.sink(1);
        }
    }

    /**
     * Update the stock of some item by some amount
     * Requires proper use of the .getSize() and .get() methods in the Sector class
     * Requires proper use of the .updateStock() method in the Product class
     * @param id The id of the item to restock
     * @param amount The amount by which to update the stock
     */
    public void restockProduct(int id, int amount) {
        int i = id % 10;
        Sector s = sectors[i];
            for(int j = 1; j <= sectors[i].getSize(); j++)
            {
                if(s.get(j).getId() == id)
                {
                    s.get(j).updateStock(amount);
                    return;
                }
            }
    }
    
    /**
     * Delete some arbitrary product while maintaining the heap structure in O(logn)
     * Requires proper use of the .getSize(), .get(), .swap(), .deleteLast(), .sink() and/or .swim() methods
     * Requires proper use of the .getId() method from the Product class
     * @param id The id of the product to delete
     */
    public void deleteProduct(int id) {
        int i = id % 10;
        Sector s = sectors[i];
        for(int j = 1; j <= sectors[i].getSize(); j++)
        {
            if(s.get(j).getId() == id)
            {
                s.swap(j, sectors[i].getSize());
                s.deleteLast();
                s.sink(j);
                return;
            }
        }
    }
    
    /**
     * Simulate a purchase order for some product
     * Requires proper use of the getSize(), sink(), get() methods in the Sector class
     * Requires proper use of the getId(), getStock(), setLastPurchaseDay(), updateStock(), updateDemand() methods
     * @param id The id of the purchased product
     * @param day The current day
     * @param amount The amount purchased
     */
    public void purchaseProduct(int id, int day, int amount) {
        int i = id % 10;
        Sector s = sectors[i];
        for (int j = 1; j <= s.getSize(); j++)
        {
            Product p = s.get(j);
            if (p.getId() == id)
            {
                if(amount > p.getStock())
                {
                    return;
                }
                else
                {
                    p.setLastPurchaseDay(day);
                    int amounts = (-1) * amount;
                    p.updateStock(amounts);
                    p.updateDemand(amount);
                    s.sink(j);
                }
                return;
            }
        }
    }
    
    /**
     * Construct a better scheme to add a product, where empty spaces are always filled
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void betterAddProduct(int id, String name, int stock, int day, int demand) {
        int originalI = id % 10;
        Sector s = sectors[originalI];
        int newI = originalI;
        while(s.getSize() == 5)
        {
            newI =  (newI + 1) % 10; 
            s = sectors[newI];
            if(newI == originalI)
            {
                break;
            }
        }
        id = id / 10 * 10 + newI;
        addProduct(id, name, stock, day, demand);
    }

    /*
     * Returns the string representation of the warehouse
     */
    public String toString() {
        String warehouseString = "[\n";

        for (int i = 0; i < 10; i++) {
            warehouseString += "\t" + sectors[i].toString() + "\n";
        }
        
        return warehouseString + "]";
    }

    /*
     * Do not remove this method, it is used by Autolab
     */ 
    public Sector[] getSectors () {
        return sectors;
    }
}
