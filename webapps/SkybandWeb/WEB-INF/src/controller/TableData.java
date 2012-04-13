
package controller;

import javax.persistence.Entity;
import javax.persistence.Id;


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
