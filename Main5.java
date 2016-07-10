package nowcodehuawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径
 */
public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> l = new ArrayList<>();
		String fileName = "";
		Map<String, Integer> map = new HashMap<>();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.length() == 0)
				break;
			int start = s.lastIndexOf('\\');
			fileName = s.substring(start + 1, s.length());
			if (fileName.length() > 16)
				fileName = fileName.substring(fileName.length() - 16, fileName.length());
			if (!map.containsKey(fileName)) {
				map.put(fileName, 1);
			} else {
				map.put(fileName, map.get(fileName) + 1);
			}
			//按照出现次数排序 降序
			map = sortMapByValue(map);
			//打印map
			print(map);
		}
	}
	public static void print(Map<String, Integer> map){
		if(map.size()<=8){
			for(Entry<String, Integer> entry:map.entrySet()){
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
		}else{
			int count = 1;
			for(Entry<String, Integer> entry:map.entrySet()){
				if(count>8)break;
				System.out.println(entry.getKey()+" "+entry.getValue());
				count++;
			}
		}
		
	}

	/**
	 * 使用 Map按value进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
		Map.Entry<String, Integer> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}
}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {

		return me2.getValue().compareTo(me1.getValue());
	}
}
