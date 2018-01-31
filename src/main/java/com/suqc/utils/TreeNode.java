/**
 * Copyright 2016 CNKI Technology Co., Ltd. All rights reserved.
 * CNKI Technology Co., Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suqc.utils;

import com.suqc.pojo.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 前台页面z-tree对象
 *
 * @author WJP
 */
public class TreeNode implements Serializable{
   /**
    * serialVersionUID
    */
   private static final long serialVersionUID = -6657131728363027633L;

   public TreeNode() {
   }

   public TreeNode(Integer id, String name, Integer pId, boolean open, boolean chkDisabled) {
      super();
      this.id = id;
      this.name = name;
      this.setpId(pId);
      this.setOpen(open);
      this.chkDisabled = chkDisabled;
   }
   
   public TreeNode(String id, String name, String pId, boolean open, boolean chkDisabled) {
      super();
      this.idStr = id;
      this.name = name;
      this.pIdStr = pId;
      this.setOpen(open);
      this.chkDisabled = chkDisabled;
   }

   public static List<TreeNode> getSubjectZtree(List<Subject> subjectList){
	   List<TreeNode> nodes= new ArrayList<TreeNode>();
	   for(Subject s:subjectList){
		   TreeNode node = null;
		   if(s.getParentId().equals("-1")){
	            node = new TreeNode(s.getNum(), s.getName(), "-1", false, false);
	         }else{
	            node = new TreeNode(s.getNum(), s.getName(), s.getParentId(), false, false);
	         }
		   nodes.add(node);
	   }
	   return nodes;
   }
   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return the isParent
    */
   public boolean isParent() {
      return isParent;
   }

   /**
    * @param isParent the isParent to set
    */
   public void setParent(boolean isParent) {
      this.isParent = isParent;
   }

   /**
    * @return the id
    */
   public Integer getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(Integer id) {
      this.id = id;
   }

   public boolean isOpen() {
      return open;
   }

   public void setOpen(boolean open) {
      this.open = open;
   }

   public boolean isChecked() {
      return checked;
   }

   public void setChecked(boolean checked) {
      this.checked = checked;
   }

   /**
    * @return the pId
    */
   public Integer getpId() {
      return pId;
   }

   /**
    * @param pId the pId to set
    */
   public void setpId(Integer pId) {
      this.pId = pId;
   }

   public String getIdStr() {
      return idStr;
   }

   public void setIdStr(String idStr) {
      this.idStr = idStr;
   }

   public String getpIdStr() {
      return pIdStr;
   }

   public void setpIdStr(String pIdStr) {
      this.pIdStr = pIdStr;
   }

   /**
    * @return the chkDisabled
    */
   public boolean isChkDisabled() {
      return chkDisabled;
   }

   /**
    * @param chkDisabled the chkDisabled to set
    */
   public void setChkDisabled(boolean chkDisabled) {
      this.chkDisabled = chkDisabled;
   }

   private Integer id;
   private Integer pId;
   private String idStr;
   private String pIdStr;
   private String name;
   private boolean isParent;
   private boolean open;
   private boolean checked;
   private boolean chkDisabled;
}