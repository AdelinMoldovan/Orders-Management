package bll.validators;
import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
/**
 * The type Client age validator.
 */

public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 10;
    private static final int MAX_AGE = 60;

    public void validate(Client client) {
        if (client.getAge() < MIN_AGE || client.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }
    }
}