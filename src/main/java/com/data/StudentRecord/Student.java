package com.data.StudentRecord;

import java.util.ArrayList;


public class Student implements Subject {
    private String name;
    private int science;
    private int maths;
    private int language;
    public static ArrayList<Student> students= new ArrayList<Student>();

    public Student(String name, int science, int maths, int language) {
        this.name = name;
        this.science = science;
        this.maths = maths;
        this.language = language;
        students.add(this);
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
    public String getName(){
        return name;
    }
    public static int bestSci(){
    	int max = 0;
    	for(int i=0;i<students.size();i++)
    	{
    		max = Math.max(max, students.get(i).getScience());
    		
    	}
    	return(max);
       
        //System.out.println("Student(s) with the highest Science grade among all students:" + max);
    }
    public static int bestMath(){
    	int max = 0;
    	for(int i=0;i<students.size();i++)
    	{
    		max = Math.max(max, students.get(i).getMaths());
    		
    	}
       return(max);
       // System.out.println("Student(s) with the highest Maths grade among all students:" + max);
    }
    public static int bestLang(){
    	int max = 0;
    	for(int i=0;i<students.size();i++)
    	{
    		max = Math.max(max, students.get(i).getLanguage());
    		
    	}
    	return(max);
       //.out.println("Student(s) with the highest Language grade among all students:" + max);
    }
    
    public static int percentile() {
    	int percent = 0,count;
    	for(int i=0; i<students.size();i++)
    	{
    		count = 0;
    		for(int j=0;j<students.size();j++)
    		{
    			if(students.get(i).getLanguage() > students.get(j).getLanguage())
    			{
    				count++;
    			}
    			
    		}
    		percent = (count * 100)/(students.size()-1);
    		System.out.print("\nPercentile of Student" +(i+1) + "=" +percent);
    	
    		
    	}
		return percent;
    }
}


