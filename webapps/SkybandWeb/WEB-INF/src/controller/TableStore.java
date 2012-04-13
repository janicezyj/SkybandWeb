
package controller;
import java.util.HashMap;
import java.util.Map;

public interface TableStore {

  TableData lookup(long id);

  void store(TableData table);

  Iterable<TableData> getAll();

  TableStore THE_ONE = new MemTableStore();

  /**
   * Stores table data as a HashMap in RAM.
   */
  class MemTableStore implements TableStore {

    private final Map<Long, TableData> map = new HashMap<Long, TableData>();

    public TableData lookup(long id) {
      return map.get(id);
    }

    public void store(TableData table) {
      map.put(table.id, table);
    }

    public Iterable<TableData> getAll() {
      return map.values();
    }
  }
}
