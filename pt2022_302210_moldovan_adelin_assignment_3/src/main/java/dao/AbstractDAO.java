package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.ParameterizedType;
import connection.ConnectionFactory;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

/**
 * The type Abstract dao.
 *
 * @param <T> the type parameter
 */
@SuppressWarnings("deprecation")
public class AbstractDAO<T> {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER=Logger.getLogger(ConnectionFactory.class.getName());
    public static final String WHERE = " where ";
    public static final String DAO_INSERT = "DAO insert ";
    private final Class<T> type;
    /**
     * Instantiates a new Abstract dao.
     * //@param type the type
     */
    public AbstractDAO() {
        this.type=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Create update query string.
     *
     */
    public String createUpdateQuery(String setCol, String seteazaColoana2)
    {
        String table=type.getSimpleName();
        return "Update " +table + " Set "+setCol+"=?"+ WHERE +seteazaColoana2+"=?";
    }
    /**
     * Update.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaValoarea -seteazaValoarea
     * @param seteazaColoana2 -seteazaColoana2
     * @param seteazaValoarea2 -seteazaValoarea2
     */
    public void update (String seteazaColoana, String seteazaValoarea, String seteazaColoana2, String seteazaValoarea2) {
        Connection connection;
        PreparedStatement statement=null;
        String query=createUpdateQuery(seteazaColoana, seteazaColoana2);
        try {

            connection=ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setObject(1, seteazaValoarea);
            statement.setObject(2, seteazaValoarea2);

            statement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName()+ DAO_INSERT, e.getMessage());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            ConnectionFactory.close(statement);
        }
    }

    /**
     * Create insert query.
     *
     */
    public String createInsertQuery()
    {
        StringBuilder fields= new StringBuilder();
        StringBuilder value= new StringBuilder();
        for(Field field : type.getDeclaredFields())
        {
            String name=field.getName();
            if(fields.length()>1)
            {
                fields.append(",");
                value.append(",");
            }
            fields.append(name);
            value.append("?");
        }
        String table=type.getSimpleName();
        return "INSERT INTO " +table + "(" + fields + ") VALUES(" + value + ")";
    }
    /**
     * Insert.
     *
     * @param object the object
     */
    public void insert (Object object) {
        Connection connection;
        PreparedStatement statement=null;
        String query=createInsertQuery();
        try {
            connection=ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);

            Class<?> zclass=object.getClass();
            Field[] fields=zclass.getDeclaredFields();
            for(int i=0;i<fields.length;i++)
            {
                Field field=fields[i];
                field.setAccessible(true);
                Object value=field.get(object);
                statement.setObject((i+1), value);
            }
            statement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName()+ DAO_INSERT, e.getMessage());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            ConnectionFactory.close(statement);
        }
    }


    /**
     * Create select query.
     *
     */
    private String createSelectQuery(String field) {
        return "select " +
                " * " +
                " FROM " +
                type.getSimpleName() +
                " WHERE " + field + " =?";
    }

    /**
     * Create delete query string.
     *
     * @param seteazaColoana -seteazaColoana
     */
    public String createDeleteQuery(String seteazaColoana)
    {
        String table=type.getSimpleName();
        return "Delete from " +table + WHERE +seteazaColoana+"=?";
    }
    /**
     * Delete.
     *
     * @param seteazaColoana -seteazaColoana
     * @param seteazaValoarea -seteazaValoarea
     */
    public void delete (String seteazaColoana, String seteazaValoarea) {
        Connection connection;
        PreparedStatement statement=null;
        String query=createDeleteQuery(seteazaColoana);
        try {

            connection=ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setObject(1, seteazaValoarea);

            statement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName()+ DAO_INSERT, e.getMessage());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            ConnectionFactory.close(statement);
        }
    }

    /**
     * Find by id.
     *
     * @param valoare -valoare
     * @param seteazaColoana -seteazaColoana
     */
    public List<T> findById(String seteazaColoana,String valoare) {
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query=createSelectQuery(seteazaColoana);
        try {
            connection=ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);
            statement.setObject(1, valoare);
            resultSet=statement.executeQuery();
            return createObjects(resultSet);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName()+"DAO findById ", e.getMessage());
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
        }
        return null;
    }
    /**
     * Find all list.
     *
     */
    public List<T> findAll() {
        Connection connection;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String query="Select * from "+type.getSimpleName();
        try {

            connection=ConnectionFactory.getConnection();
            statement=connection.prepareStatement(query);

            System.out.println(statement);
            resultSet=statement.executeQuery();
            return createObjects(resultSet);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName()+"DAO findALL ", e.getMessage());
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            //ConnectionFactory.close(connection);
        }
        return null;
    }


    /**
     * CreateObject.
     *
     * @param resultSet -resultSet
     */
    private List<T> createObjects(ResultSet resultSet){
        List<T> list= new ArrayList<>();
        try {
            while(resultSet.next()) {
                T instance=type.newInstance();
                for(Field field : type.getDeclaredFields()) {
                    Object value=resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(field.getName(),type);
                    Method method=propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        }
        catch(Exception e) {
            System.out.println();
        }
        return list;
    }
}