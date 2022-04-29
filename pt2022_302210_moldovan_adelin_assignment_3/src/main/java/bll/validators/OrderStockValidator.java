package bll.validators;
import java.util.List;
import bll.ExceptiePentruStock;
import dao.ProductDAO;
import model.Product;
import model.Orders;

/**
 * The type Order stock validator.
 */
public class OrderStockValidator implements Validator<Orders> {

    @Override
    public void validate(Orders t) throws ExceptiePentruStock {
        List<Product> st = (new ProductDAO()).findById("id",((Integer)(t.getIdProduct())).toString());
        if(st.get(0).getStock()<t.getQunatity()) {
            throw new ExceptiePentruStock("Produsul nu mai este in stoc.");
        }
    }
}