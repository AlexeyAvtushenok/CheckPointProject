package by.epam.training.service.impl;

import by.epam.training.bean.entity.Goods;
import by.epam.training.dao.BCDao;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.exception.DAOException;
import by.epam.training.dao.impl.DbDAO;
import by.epam.training.service.EditGoodsService;
import by.epam.training.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class EditGoods implements EditGoodsService {
    @Override
    public void addGoods(int id, String category, String name, double cost) throws ServiceException {
        if (category == null || "".equals(category) || name == null || "".equals(name)) {
            throw new ServiceException("message");// да что бы у тебя всю жизнь в логах только такие мессэджи и встречались
        }
        DAOFactory factory = DAOFactory.getInstance();
        BCDao dao = factory.getNBDao();// какое-такое getNBDAO?
        try {
            dao.addGoods(id, category, name, cost);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }


    @Override
    public void deleteGoods(int id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        BCDao dao = factory.getNBDao();
        try {
            dao.deleteGoods(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }



}
