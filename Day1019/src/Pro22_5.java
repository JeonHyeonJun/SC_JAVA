import java.util.ArrayList;
import java.util.Scanner;

//p.576 5������
//�ɻ����� 10���� ������ �Է¹޾Ƽ� �ְ�,���������� ������ ���� ���ϴ� ���α׷�
//������ doubleŸ��
public class Pro22_5 {
	static final int CNT = 10;	//10���� ����� ������ ����.
								//���⿡ public�� ���̸� �ٸ� Ŭ���������� �� ����� ����� �� �ִ�.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<>();
		
		//10���� ������ �Է¹���
		for(int i=0; i<CNT; i++) {
			System.out.print("�ɻ������� ����: ");
			Double d = new Double(scan.nextDouble());
			list.add(d);
		}
		
		double max = list.get(0);	//�ְ������� ���� ����. �ʱⰪ�� list�� 0������ �ִ� ������ ����
		double min = list.get(0);	//���������� ���� ����. �ʱⰪ�� list�� 0������ �ִ� ������ ����
		double sum = 0;				//������ ���� ����
		
		//�ְ�,����,������ ����
		for(int i=0; i<CNT; i++) {
			if(list.get(i) > max)
				max = list.get(i);	//list.get(i)�� ����max������ ũ�ٸ� max�� list.get(i)�� ����
			if(list.get(i) < min)
				min = list.get(i);	//list.get(i)�� ����min������ �۴ٸ� min�� list.get(i)�� ����
			sum += list.get(i);		//sum�� list.get(i)�� ����
		}
		
		sum = sum-max-min;	//���տ��� �ְ�,���� ������ ��
		
		System.out.println("������  ��: "+sum);
		
	}
}
