package matrix;


//���� ������������������ �������������� ����� �1 �2 ,..., �n. ��������, ����� �� ��� ������������.

public class Matrix {

	public static void main(String[] args) {
		
		Boolean flag = true;
		int[] vector = new int[(int) (Math.random() * 30)];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) (Math.random() * 100);
			System.out.print(vector[i] + " ");
		}
		
		System.out.print("\n");
		
		for (int i = 0; i < vector.length - 1; i++) {
			if (vector[i] > vector[i + 1]){
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println("������������������ ������������");
		} else {
			System.out.println("������������������ ��������������");
		}  
	}

}
