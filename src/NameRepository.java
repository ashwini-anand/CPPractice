public class NameRepository implements MineContainer {

  String names[] = {"abc","ram"};

  @Override
  public MineIterator getIterator() {
    return new NameArrayIterator();
  }

  private class NameArrayIterator implements MineIterator{
    int index;
    @Override
    public boolean hasNext() {
      if(index < names.length) return true;
      return false;
    }

    @Override
    public Object next() {
      if(hasNext()) return names[index++];
      return null;
    }
  }

  public static void main(String[] args) {
    NameRepository nr = new NameRepository();
    MineIterator mi = nr.getIterator();
    while(mi.hasNext()){
      System.out.println((String) mi.next());
    }
  }
}
