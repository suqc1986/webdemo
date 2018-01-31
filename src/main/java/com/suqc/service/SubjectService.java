package com.suqc.service;

import com.suqc.dao.SubjectDao;
import com.suqc.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SubjectService {
   @Autowired
   SubjectDao subjectDao;
   
   /*
    * 获取所有的学科信息
    */
   public List<Subject> getAllSubject() {
      if(allSubjectList == null || allSubjectList.size() == 0) {
    	  setAllSubjectList();
       }
	  return allSubjectList;
  }

   public List<Subject> getSubject(String num) {
      if(subjectMap == null || subjectMap.size() == 0) {
         setSubjectMap();
      }

      return subjectMap.get(num);
   }

   private void setSubjectMap() {
      lock.lock();

      try {
         if(subjectMap == null) {
            subjectMap = new HashMap<String, List<Subject>>();
            List<Subject> subjectList = subjectDao.query(null);

            for(Subject subject : subjectList) {
               if(subjectMap.get(subject.getParentId()) == null)
                  subjectMap.put(subject.getParentId(), new ArrayList<Subject>());

               subjectMap.get(subject.getParentId()).add(subject);
            }
         }
      } finally {
         lock.unlock();
      }
   }
   
   public Map<String, String> getSubjectNameMap() {
      if(subjectNameMap == null || subjectNameMap.size() == 0) {
         setSubjectNameMap();
      }

      return subjectNameMap;
   }

   private void setSubjectNameMap() {
      lock.lock();

      try {
         if(subjectNameMap == null) {
            subjectNameMap = new HashMap<String, String>();
            List<Subject> subjectList = subjectDao.query(null);

            for(Subject subject : subjectList) {
               subjectNameMap.put(subject.getNum(), subject.getName());
            }
         }
      } finally {
         lock.unlock();
      }
   }
   
   private void setAllSubjectList() {
	      lock.lock();

	      try {
	         if(allSubjectList == null) {
	             allSubjectList = subjectDao.query(null);
	         }
	      } finally {
	         lock.unlock();
	      }
	   }

   private static Map<String, List<Subject>> subjectMap;
   private static Map<String, String> subjectNameMap;
   private static List<Subject> allSubjectList;
   private static Lock lock = new ReentrantLock();

}