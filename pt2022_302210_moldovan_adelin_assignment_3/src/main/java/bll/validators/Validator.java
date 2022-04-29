package bll.validators;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * The interface Validator.
 *
 * @param <T> the type parameter
 */
public interface Validator<T> {

    /**
     * Validate.
     *
     * @param t the t
     */
    void validate(T t) throws Exception;
}