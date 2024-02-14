import java.io.Serializable;

class Food implements Serializable {
    int itemno;
    String itemName;
    int quantity; // New instance variable
    float price;

    // Updated constructor to include quantity
    Food(int itemno, String itemName, int quantity, float price) {
        this.itemno = itemno;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}
