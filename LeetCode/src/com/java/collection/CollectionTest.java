package com.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		LinkedList<String> linklist = new LinkedList<>();
		linklist.add("zwb");
		linklist.add("hls");
		String x = linklist.getLast();
		System.out.println(x);
		linklist.set(1, "zzz");
		String x1 = linklist.getLast();
		System.out.println(x1);
		System.out.println(linklist.indexOf("zzz"));
		Vector<String> vector = new Vector<>();
		vector.add("zzzz");
		vector.add("aaaa");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(6, "qqq");
		map.put(3, "qwe");
		map.put(1, "qwe");
		map.put(-9, "qwe");
		System.err.println(map.hashCode());
		System.out.println();
		//System.out.println(Math.);
		//对key进行排序 以map作为构造函数的参数
		TreeMap<Integer, String> tmap = new TreeMap<>(map);
		for(Entry<Integer, String> X:tmap.entrySet()){
			System.out.println(X.getValue()+"--"+X.getKey());
		}
		LinkedHashMap lhmap = new LinkedHashMap<>();
	}

}
