package com.virtusa.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ArraysDemo {
	
	int count=0;
	Map map=new TreeMap();
	public void m1(int arr[]){
		int size=arr.length;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(arr[i] == arr[j])
				{
					count++;
				}
			}
			map.put(arr[i],count);
			count=0;
		}
		System.out.println(map);
		Set setKey=map.keySet();
		
		System.out.println(setKey);
		Collection setValues=map.values();
		/*for(int i=0;i<setValues.size();i++)
		{
			
		}*/
		//Iterator<Integer> itr=setValues.iterator();
		
		for (Object object : setValues) {
			//System.out.println(object.toString());
			Integer intg=(Integer) object;
			for (Object object2 : setKey) {
				while(intg>0)
				{
					System.out.print(object2);
					intg--;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		ArraysDemo arraysDemo = new ArraysDemo();
		int[] arr;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size");
		int size=sc.nextInt();
		arr=new int[size];
		System.out.println("enter the elements");
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		arraysDemo.m1(arr);
		
	}
}
