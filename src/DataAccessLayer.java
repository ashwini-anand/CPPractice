public interface DataAccessLayer {
  void save(Object obj);
}

class PostgresDataAccessLayer1 implements DataAccessLayer{

  @Override
  public void save(Object obj) {
    //logic to save in postgres DB
  }
}

class JsonDataAccessLayer1 implements DataAccessLayer{

  @Override
  public void save(Object obj) {
    //logic to save as json in local file system
  }
}