package by.epam.training.dao.impl;

import by.epam.training.bean.entity.Goods;
import by.epam.training.dao.BCDao;
import by.epam.training.dao.exception.DAOException;

import java.sql.*;// не импортим со *
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class DbDAO implements BCDao {
    private static final String url = "jdbc:mysql://localhost:3306/bicycle_goods?autoReconnect=true&useSSL=false";
    private static final String addStatement = "INSERT INTO features (idfeatures, category, name, cost) VALUES (?,?,?,?)";
    private static final String deleteStatement = "DELETE FROM features WHERE idfeatures = (?)";
    private static final String selectStatement = "SELECT * FROM `bicycle_goods`.`features`;";
    @Override
    public void addGoods(int id, String category, String name, double cost) throws DAOException {


        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DriverManager.getConnection(url,"root","root");// что делаем с константными строками?

            try {// try в try в одной области видимости - что за бред?
                st = connection.prepareStatement(addStatement);
                st.setInt(1, id);
                st.setString(2, category);
                st.setString(3, name);
                st.setDouble(4, cost);
                st.executeUpdate();
            } catch (SQLException e1) {
                throw new DAOException();// о, потерял исходное исключение, растаряша
            }
        } catch (SQLException e) {
          throw new DAOException();

        }
        finally {
            if (connection!= null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw  new DAOException();
                }
            try {
                st.close();// ты уже соединение закрыл, зачем же со statement-от мучаешься?
            } catch (SQLException e) {
                throw new DAOException();// ну и зачет здесь в блоке finelly выбрасывать исключение?
            }

        }
    }

    @Override
    public void deleteGoods(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DriverManager.getConnection(url,"root","root");


            try {
                st = connection.prepareStatement(deleteStatement);
                st.setInt(1, id);
                st.executeUpdate();
            } catch (SQLException e1) {
                throw new DAOException();
            }
        } catch (SQLException e) {
            throw new DAOException();

        }
        finally {
            if (connection!= null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw  new DAOException();
                }
            try {
                st.close();
            } catch (SQLException e) {
                throw new DAOException();
            }

        }
    }

    @Override
    public List<Goods> findGoods(String category)throws DAOException {
        List<Goods> list = new ArrayList<>();
        StringBuilder str = new StringBuilder("SELECT * FROM `bicycle_goods`.`features` WHERE `category` =" );
        str.append("'");
        str.append(category);
        str.append("'");
        Connection connection = null;
        Statement st = null;
        try {
            connection = DriverManager.getConnection(url,"root","root");

             st = connection.createStatement();
            try {

                ResultSet rs = st.executeQuery(str.toString());
                while (rs.next())
                {
                    list.add(new Goods(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
                }
            } catch (SQLException e1) {
                throw new DAOException();
            }
        } catch (SQLException e) {
            throw new DAOException();

        }
        finally {
            if (connection!= null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw  new DAOException();
                }
            try {
                st.close();
            } catch (SQLException e) {
                throw new DAOException();
            }

        }
        return list;
    }

    @Override
    public List<Goods> findGoods() throws DAOException {
        List<Goods> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DriverManager.getConnection(url,"root","root");

            try {
                st = connection.prepareStatement(selectStatement);
                ResultSet resultSet = st.executeQuery();
                while (resultSet.next())
                {
                    list.add(new Goods(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
                    // а вот вспомнишь ли ты, что возвращает getString(3), не лазя по другому коду?
                }
            } catch (SQLException e1) {
                throw new DAOException();
            }
        } catch (SQLException e) {
            throw new DAOException();

        }
        finally {
        if (connection!= null)
            try {
                connection.close();
            } catch (SQLException e) {
                throw  new DAOException();
            }
            try {
                st.close();
            } catch (SQLException e) {
                throw new DAOException();
            }

        }
        return list;
    }





}

