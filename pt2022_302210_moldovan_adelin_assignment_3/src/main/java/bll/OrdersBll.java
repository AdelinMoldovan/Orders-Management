package bll;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import bll.validators.OrderStockValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import model.Client;
import model.Orders;
import model.Product;

/**
 * The type Orders bll.
 */
public class OrdersBll {
    private final List<Validator<Orders>> validators;

    /**
     * Insert order.
     *
     * @param order the order
     */
    public void insertOrder(Orders order) throws Exception {
        for (Validator<Orders> validator : validators) {
            validator.validate(order);
        }
        List<Product> produs = (new ProductDAO()).findById("id",((Integer)(order.getIdProduct())).toString());
        List<Client> client = (new ClientDAO()).findById("id",((Integer)(order.getIdClient())).toString());
        (new ProductBll()).updateProduct("stock",((Integer)(produs.get(0).getStock()-order.getQunatity())).toString() , "id",((Integer)(order.getIdProduct())).toString());
        (new OrdersDAO()).insert(order);

        try {
            PrintWriter writer = new PrintWriter("DateDespreFacturare.txt", StandardCharsets.UTF_8);
            writer.println("Factura este:");
            writer.println("Detaliile clientului de facturare sunt: "); writer.println(client.get(0).toString());
            writer.println("Produsul care a fost comandat este: \n"); writer.println(produs.get(0).toString()+"\n");
            writer.println("Numarul de produse pe care clientul le-a cumparat este:"+order.getQunatity());
            writer.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Instantiates a new Order bll.
     */
    public OrdersBll() {
        validators = new ArrayList<>();
        validators.add(new OrderStockValidator());
    }

    /**
     * Find all orders.
     *
     */
    public List<Orders> findAll(){
        List<Orders> l;
        l=(new OrdersDAO()).findAll();
        return l;
    }
}