package by.epam.training.bean;

/**
 * Created by Алексей on 19.10.2016.
 */
public class AddRequest extends Request{
    private int addID;
    private String addCategory;
    private String addName;
    private double addCost;

    public int getAddID() {
        return addID;
    }

    public void setAddID(int addID) {
        this.addID = addID;
    }

    public String getAddCategory() {
        return addCategory;
    }

    public void setAddCategory(String addCategory) {
        this.addCategory = addCategory;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public double getAddCost() {
        return addCost;
    }

    public void setAddCost(double addCost) {
        this.addCost = addCost;
    }
}
