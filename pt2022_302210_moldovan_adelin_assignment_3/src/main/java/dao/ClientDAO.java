package dao;

import java.util.List;
import model.Client;

/**
 * The type Client dao.
 */
public class ClientDAO extends AbstractDAO<Client> {

    /**
     * Update client.
     *
     * @param seteazaColoana -setCol
     * @param valoare -find by id a
     */
    public List<Client> findById(String seteazaColoana, String valoare) {
        return super.findById(seteazaColoana, valoare);
    }

    /**
     * Update.
     *
     * @param seteazaValoaarea -setVal
     * @param seteazaColoana2 -setCol1
     * @param seteazaColoana  -setCol
     * @param setVal1 -setVal1
     */
    public void update (String seteazaColoana, String seteazaValoaarea, String seteazaColoana2, String setVal1) {
        super.update(seteazaColoana, seteazaValoaarea, seteazaColoana2, setVal1);
    }

    /**
     * Insert client.
     *
     * @param object -insert a
     */
    public void insert(Object object) {
        super.insert(object);
    }

    /**
     * Find all clients.
     *
     */
    public List<Client> findAll(){
        return super.findAll();
    }

    /**
     * Delete.
     *
     * @param seteazaColoana -setCol
     * @param seteazaValoarea  -setVal
     */
    public void delete (String seteazaColoana, String seteazaValoarea) {
        super.delete(seteazaColoana, seteazaValoarea);
    }
}