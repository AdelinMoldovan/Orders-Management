package  model;

/**
 * The type Orders.
 */
public class Orders {
    private int idOrder;
    private int idClient;
    private String nameClient;
    private int idProduct;
    private String nameProduct;
    private int quantity;

    /**
     * Instantiates a new Orderr.
     *
     * @param idOrder the order id
     * @param idClient the client it
     * @param nameClient the client name
     * @param idProduct the product id
     * @param nameProduct  the product name
     * @param quantity  the quantity
     */
    public Orders(int idOrder,int idClient, String nameClient, int idProduct, String nameProduct, int quantity) {
        this.idOrder =idOrder;
        this.idClient=idClient;
        this.nameClient=nameClient;
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.quantity=quantity;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQunatity() {
        return this.quantity;
    }

    /**
     * Sets quantity.
     *
     * @param cantitate -quantity
     */
    public void setQunatity(int cantitate) {
        quantity=cantitate;
    }

    /**
     * Gets product id.
     *
     */
    public int getIdProduct() {
        return this.idProduct;
    }

    /**
     * Sets product id.
     *
     * @param productId -idProduct
     */
    public void setIdProduct(int productId) {
        idProduct=productId;
    }

    /**
     * Gets client id.
     *
     */
    public int getIdClient() {
        return this.idClient;
    }

    /**
     * Sets client id.
     *
     * @param clientId idClient
     */
    public void setIdClient(int clientId) {
        idClient=clientId;
    }

    /**
     * Gets order id.
     *
     */
    public int getIdOrder() {
        return this.idOrder;
    }

    /**
     * Sets order id.
     *
     * @param orderId -idOrder
     */
    public void setIdOrder(int orderId) {
        idOrder=orderId;
    }

    /**
     * Gets client name.
     *
     */
    public String getNameClient() {
        return this.nameClient;
    }

    /**
     * Sets client name.
     *
     * @param clientName -nameClient
     */
    public void setNameClient(String clientName) {
        this.nameClient=clientName;
    }

    /**
     * Gets name product.
     *
     */
    public String getNameProduct() {
        return this.nameProduct;
    }

    /**
     * Sets name product.
     *
     * @param productName -nameProduct
     */
    public void setNameProduct(String productName) {
        this.nameProduct=productName;
    }

    /**
     * toString() method.
     *
     */
    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", idClient=" + idClient +
                ", nameClient='" + nameClient + '\'' +
                ", idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}