package by.epam.training.service.impl;

import by.epam.training.bean.entity.Goods;
import by.epam.training.dao.BCDao;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.exception.DAOException;
import by.epam.training.service.SearchGoodsService;
import by.epam.training.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Алексей on 19.10.2016.
 */
public class SearchGoods implements SearchGoodsService {
    @Override
    public List<Goods> returnGoods(String category) throws ServiceException {
       List<Goods> list  = null;
        if ( category == null ||  "".equals(category))
        {
            throw new ServiceException("message");
        }
        DAOFactory factory  = DAOFactory.getInstance();
        BCDao dao = factory.getNBDao();

        try {
            list = dao.findGoods(category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return list;
    }

    @Override
    public List<Goods> returnGoods() throws ServiceException {
        List<Goods> list  = null;

        DAOFactory factory  = DAOFactory.getInstance();
        BCDao dao = factory.getNBDao();

        try {
            list = dao.findGoods();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return list;
    }

}
