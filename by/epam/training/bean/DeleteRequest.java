package by.epam.training.bean;

/**
 * Created by Алексей on 19.10.2016.
 */
public class DeleteRequest extends Request{
    private int deleteId;

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId (int deleteId) {
        this.deleteId = deleteId;
    }
}
