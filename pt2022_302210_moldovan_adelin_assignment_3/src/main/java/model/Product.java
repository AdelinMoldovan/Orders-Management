package model;

/**
 * The type Product.
 */
public class Product {
    private int id;
    private String name;
    private int stock;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param id       the id
     * @param name     the name
     * @param stock    the stock
     */
    public Product(int id, String name, int stock) {
        this.id=id;
        this.name=name;
        this.stock=stock;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id=id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name=name;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock=stock;
    }

    /**
     * toString() method.
     *
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}