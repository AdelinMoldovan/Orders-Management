package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

/**
 * The type Product bll.
 */
public class ProductBll {


    /**
     * Lista de validatori
     */
    private final List<Validator<Product>> validators;

    /**
     * Instantiates a new Product bll.
     */
    public ProductBll() {
        validators = new ArrayList<>();
    }

    /**
     * Find all products array list.
     *
     * @return the array list
     */
    public List<Product> findAll(){
        List<Product> produse;
        produse=(new ProductDAO()).findAll();
        return produse;
    }

    /**
     * Find product list.
     *
     * @return the list
     */
    public List<Product> findProduct(String seteazaColoana, String valoare) {
        List<Product> produse = (new ProductDAO()).findById(seteazaColoana,valoare);
        if (produse == null) {
            throw new NoSuchElementException("Produsul cu tare"+ seteazaColoana+"=" + valoare + " nu a fost gasit.");
        }
        return produse;
    }

    /**
     * Update product.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaColoana2 -seteazaColoana2
     * @param seteazaValoarea -seteazaValoarea
     * @param seteazaValoarea2 -seteazaValoarea2
     */
    public void updateProduct(String seteazaColoana, String seteazaValoarea, String seteazaColoana2, String seteazaValoarea2) {
        (new ProductDAO()).update(seteazaColoana, seteazaValoarea, seteazaColoana2, seteazaValoarea2);

    }
    /**
     * Insert product.
     *
     * @param product the product
     */
    public void insertProduct(Product product) throws Exception {
        for (Validator<Product> validator : validators) {
            validator.validate(product);
        }
        (new ProductDAO()).insert(product);
    }

    /**
     * Delete product.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaValoarea -seteazaValoarea
     */
    public void deleteProduct(String seteazaColoana, String seteazaValoarea) {
        (new ProductDAO()).delete(seteazaColoana, seteazaValoarea);
    }
}