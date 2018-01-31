package com.suqc.pojo;

public class Subject {

   private Integer id;
   private String num;
   private String name;
   private String parentId;
   private Integer level;
   private String egnlishName;
   private String displayName;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNum() {
      return num;
   }

   public void setNum(String num) {
      this.num = num;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getParentId() {
      return parentId;
   }

   public void setParentId(String parentId) {
      this.parentId = parentId;
   }

   public Integer getLevel() {
	   return level;
   }
	
   public void setLevel(Integer level) {
	   this.level = level;
   }

public String getDisplayName() {
	return displayName;
}

public void setDisplayName(String displayName) {
	this.displayName = displayName;
}

public String getEgnlishName() {
	return egnlishName;
}

public void setEgnlishName(String egnlishName) {
	this.egnlishName = egnlishName;
}

}
