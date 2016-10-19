package by.epam.training.dao;

import by.epam.training.dao.impl.DbDAO;

/**
 * Created by Алексей on 19.10.2016.
 */
public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private BCDao nbDao = new DbDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return INSTANCE;
    }

    public BCDao getNBDao(){
        return nbDao;
    }
}
