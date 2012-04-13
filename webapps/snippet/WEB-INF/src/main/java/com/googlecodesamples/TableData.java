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

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Stores data for registered table.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */

@Entity
public class TableData {
  @Id public long id;
  public String title;
  public String oauthAccess;
  public String oauthSecret;

  public TableData() {
  }

  public TableData(long id, String title, String oauthAccess, String oauthSecret) {
    this.id = id;
    this.oauthAccess = oauthAccess;
    this.oauthSecret = oauthSecret;
    this.title = title;
  }
}
