import java.util.ArrayList;
import java.util.Collections;

public class DataArrayList {
	public static void main(String[] args) {
		ArrayList<Data> list = new ArrayList<>();
		
		list.add(new Data(10, "��ǻŸ"));
		list.add(new Data(5, "Ű����"));
		list.add(new Data(7, "�����"));
		list.add(new Data(5, "���콺"));
		list.add(new Data(6, "����Ŀ"));
		
		Data tmp = new Data(5, "Ű����");
		
		System.out.println(list);	//DataŬ������ toString()�� Overriding�Ǿ����
		System.out.println(list.size());
		System.out.println(list.get(0));	//DataŬ������ toString()�� Overriding�Ǿ����
		System.out.println(list.contains(tmp));	//DataŬ������ equals()�� Overriding�Ǿ����
		System.out.println(list.indexOf(tmp));	//DataŬ������ equals()�� Overriding�Ǿ����
		
		Collections.sort(list);	//����. DataŬ������ Comparable<Data> �������̽��� ��ӹ޾ƾ��ϰ�
								//�ش� �������̽��� �߻�޼ҵ带 ����������Ѵ�.
		System.out.println(list);
	}
}
