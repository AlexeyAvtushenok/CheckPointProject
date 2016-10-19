package by.epam.training.dao;

import by.epam.training.bean.entity.Goods;
import by.epam.training.dao.exception.DAOException;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public interface BCDao {
    void addGoods(int id, String category, String name, double cost) throws DAOException;
    void deleteGoods(int id) throws DAOException;
    List< Goods> findGoods(String name) throws DAOException;
    List< Goods> findGoods() throws DAOException;


}
