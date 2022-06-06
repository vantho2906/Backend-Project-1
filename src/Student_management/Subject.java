package Student_management;

import java.util.Date;

public class Subject {
   private String id;
   private String name;
   private int credit;

   public Subject(String id, String name, int credit) {
      setId(id);
      setName(name);
      setCredit(credit);
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getCredit() {
      return credit;
   }

   public void setCredit(int credit) {
      this.credit = credit;
   }
}
