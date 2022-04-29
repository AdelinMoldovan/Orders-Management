package dao;

import java.util.List;
import model.Orders;

/**
 * The type Orders dao.
 */
public class OrdersDAO extends AbstractDAO<Orders>{

    /**
     * Find by id.
     *
     * @param seteazaColoana -setCol
     * @param valoare -find by id valoare
     */
    public List<Orders> findById(String seteazaColoana, String valoare) {
        return super.findById(seteazaColoana, valoare);
    }


    /**
     * Find all orders.
     *
     */
    public List<Orders> findAll(){
        return super.findAll();
    }

    /**
     * Insert.
     *
     * @param object -insert object
     */
    public void insert(Object object) {
        super.insert(object);
    }
}