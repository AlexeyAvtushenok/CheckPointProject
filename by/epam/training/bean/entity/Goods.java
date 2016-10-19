package by.epam.training.bean.entity;

/**
 * Created by Алексей on 19.10.2016.
 */
public class Goods {
    int id;
    String category;
    String name;
    double cost;

    public Goods(int id, String category, String name, double cost) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append(" ");
        builder.append(category);
        builder.append(" ");
        builder.append(name);
        builder.append(" ");
        builder.append(cost);
        builder.append("\n");
        return builder.toString();
    }



}
