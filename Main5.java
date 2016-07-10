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
����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš� 
����:
1.��¼���8�������¼������ͬ�Ĵ����¼(���ļ����ƺ��к���ȫƥ��)ֻ��¼һ��������������ӣ�(�ļ����ڵ�Ŀ¼��ͬ���ļ������к���ͬҲҪ�ϲ�)
2.����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���(����ļ�����ͬ����ֻ���ļ����ĺ�16���ַ����к���ͬ��Ҳ��Ҫ�ϲ�)
3.������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·��
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
			//���ճ��ִ������� ����
			map = sortMapByValue(map);
			//��ӡmap
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
	 * ʹ�� Map��value��������
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
