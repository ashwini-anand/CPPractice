public class BusinessLayer {
  private DataAccessLayer dal;

  public BusinessLayer(DataAccessLayer dal) {
    this.dal = dal;
  }

  public void saveObject(Object obj){
    dal.save(obj);
  }
}
