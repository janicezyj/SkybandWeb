/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecodesamples;

import java.util.HashMap;
import java.util.Map;


/**
 * Stores table data by ID.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
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
