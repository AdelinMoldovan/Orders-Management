package dao;

import java.util.List;
import model.Product;

/**
 * The type Product dao.
 */
public class ProductDAO extends AbstractDAO<Product> {


    /**
     * Delete.
     *
     * @param seteazaColoana -setCol
     * @param seteazaValoarea -setVal
     */
    public void delete(String seteazaColoana, String seteazaValoarea) {
        super.delete(seteazaColoana, seteazaValoarea);
    }

    /**
     * Update.
     *
     * @param seteazaColoana -setCol
     * @param seteazaValoaarea -setVal
     * @param setVal1 -setVal1
     * @param seteazaColoana2 -setCol1
     */
    public void update(String seteazaColoana, String seteazaValoaarea, String seteazaColoana2, String setVal1) {
        super.update(seteazaColoana, seteazaValoaarea, seteazaColoana2, setVal1);
    }

    /**
     * Find by id.
     *
     * @param seteazaColoana -setCol
     * @param valoare -find by id a
     */

    public List<Product> findById(String seteazaColoana, String valoare) {
        return super.findById(seteazaColoana, valoare);
    }

    /**
     * Insert.
     *
     * @param object -insert a
     */
    public void insert(Object object) {
        super.insert(object);
    }

    /**
     * Find all products.
     *
     */
    public List<Product> findAll(){
        return super.findAll();
    }
}