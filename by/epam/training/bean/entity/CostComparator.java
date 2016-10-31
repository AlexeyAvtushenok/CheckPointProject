package by.epam.training.bean.entity;

import java.util.Comparator;

/**
 * Created by Алексей on 19.10.2016.
 */
// с какого перепугу в этот пакет компаратор затесался
// вот где используешь его, там и храни
public class CostComparator implements Comparator<Goods>{

    @Override
    public int compare(Goods o1, Goods o2) {
        Double cost1 = o1.getCost();
        return cost1.compareTo(o2.getCost());

    }
}
