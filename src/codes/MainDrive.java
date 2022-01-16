package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		로또 시뮬레이터 제작
//		1) 내 번호 6개 입력
//		내 숫자 6개 저장 배열
		int[] myNumberArr = new int[6];
		
//		컴퓨터 자원 낭비를 막기 위해, Scanner는 for문 밖에서 생성.
		Scanner myScanner = new Scanner(System.in);
		
		for (int i = 0; i < myNumberArr.length; i++) {

//			제대로 된 숫자가 들어올때까지 -> 각 숫자를 계속 반복으로 받아야함.
			
			while(true) {
//				내 번호를 자리에 입력받아 넣자. => Scanner 필요.
				
//				몇번째 숫자? 안내문.
				
				System.out.println(i+1+"번째 숫자 입력 : ");
				
//				숫자 입력받기.
				int inpputNum = myScanner.nextInt();
				
//				1. 1~45의 범위인가?
				
				boolean isRangeOk = (1 <= inpputNum) && (inpputNum <= 45);
				
//				2. 이미 등록된 숫자가 아닌가? => 중복이 아닌가?
				
//				1,2를 모두 통과하면 => 내 번호 배열에 등록 + 다음 숫자로 이동.
			}

			
		}

	}

}
