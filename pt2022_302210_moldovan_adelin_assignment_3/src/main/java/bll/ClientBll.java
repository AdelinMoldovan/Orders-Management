package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;


/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
/**
 * The type Client bll.
 */
public class  ClientBll {

    private final List<Validator<Client>> validators;

    /**
     * Instantiates a new Client bll.
     */
    public ClientBll() {
        validators = new ArrayList<>();
        validators.add(new ClientAgeValidator());
    }

    /**
     * Find all clients array list.
     *
     * @return the array list
     */
        public List<Client> findClient(String seteazaColoana,String valoare) {
        List<Client> clienti = (new ClientDAO()).findById(seteazaColoana,valoare);
        if (clienti == null) {
            throw new NoSuchElementException("Clientul cu tare: "+ seteazaColoana+" =" + valoare + "nu a fost gasit.");
        }
        return clienti;
    }

    /**
     * Update client.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaValoarea -seteazaValoarea
     * @param seteazaColoana2 -seteazaColoana2
     * @param seteazaValoarea2 -seteazaValoarea2
     */
    public void updateClient(String seteazaColoana, String seteazaValoarea, String seteazaColoana2, String seteazaValoarea2) {
        (new ClientDAO()).update(seteazaColoana, seteazaValoarea, seteazaColoana2, seteazaValoarea2);
    }

    /**
     * FindAll client.
     *
     */
    public List<Client> findAll(){
        List<Client> l;
        l=(new ClientDAO()).findAll();
        return l;
    }

    /**
     * Insert client.
     *
     * @param client the client
     */
    public void insertClient(Client client) throws Exception {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        (new ClientDAO()).insert(client);
    }

    /**
     * Delete client.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaValoare -seteazaValoare
     */
    public void deleteClient(String seteazaColoana, String seteazaValoare) {
        (new ClientDAO()).delete(seteazaColoana, seteazaValoare);
    }
}