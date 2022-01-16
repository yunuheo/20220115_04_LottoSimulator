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
				int inputNum = myScanner.nextInt();
				
//				1. 1~45의 범위인가?
				
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45);
				
//				2. 이미 등록된 숫자가 아닌가? => 중복이 아닌가?
				
				boolean isDuplOk = true; //일단은 써도 된다고 전제 -> 중복임을 발견하면, 쓰면 안된다고 변경.
				
//				내 번호 목록을 돌아보다가 => 입력한 숫자와 같은게 있다면? => 이미 등록된 숫자. (중복) => 사용하면 안됌.
				
				for (int myNum : myNumberArr) {
//					내 번호랑 입력번호가 같은가?
					if (myNum == inputNum) {
//						같은걸 발견! => 중복검사 통과 X.
						isDuplOk = false;
						
//						더이상 검사할 필요 X
						break;
					}
				}
				
//				1,2를 모두 통과하면 => 내 번호 배열에 등록 + 다음 숫자로 이동.
				
				if (isRangeOk && isDuplOk) {
//					검사를 통과한 상황.
					
//					내 번호 목록에 -> 입력한 숫자를 기록.
					myNumberArr[i] = inputNum;
					
//					무한반복 종료 -> 다음 숫자로 이동.
					break;
				}
				else if(!isRangeOk) {
//					범위검사에 탈락했나요?
					System.out.println("로또는 1~45의 숫자만 입력 가능합니다.");
				}
				else {
//					통과 X, 범위검사 O => 중복검사에서 탈락.
					System.out.println("중복된 숫자는 입력할 수 없습니다.");
				}
			}

			
		}
//		내 번호 6개 입력 완료.
		
//		당첨번호 6개 생성 => 임시로, 숫자 6개 고정.
		
//		int[] winNumberArr =  { 2, 7, 15, 30, 35, 40 };
		
//		실제로 랜덤 6개 생성 (당첨번호 뽑기)
		
		int[] winNumberArr = new int[6];
//				6개의 랜덤 숫자.
		
		for (int i = 0; i < winNumberArr.length; i++) {

//			랜덤도 사용가능한 수가 나올때까지 반복
			
			while (true) {
				
//				컴퓨터에게 1~45 랜덤 추출 요청.
			
//				Math.random()*45 + 1 => int로 강제변환 (소수점 버림) : 1 <= (정수)결과물*45+1 < 46 : 1~45
				int randomNum = (int)(Math.random() * 45+  1);
//				랜덤숫자를 중복검사 수행.
//				당첨번호에, 랜덤숫자와 같은게 있다면? 중복검사 탈락.
				
				boolean isDuplOk = true;
				
				for (int winNum : winNumberArr) {
					
					if (winNum == randomNum) {
						isDuplOk = false;
						break;
					}
				}
				
//				중복검사에 통과하면, 다음 숫자.
				
			}
				
		}
		
//		등수 판정 하기.

//		내번호 하나를 들고 => 당첨번호 비교 6회 반복. => 내 번호 6개에 대해서 통째로 반복. (for 중첩)
//		배열의 내용물을 꺼내보는 for
		
//		맞춘 갯수를 기록변수
		int correctCount = 0;
		
		for (int myNum : myNumberArr) {
			for (int winNum : winNumberArr ) {
				if (myNum == winNum) {
					
//					같은 숫자 하나 추가 발견!
					correctCount++;
					
				}
			}
		}
		System.out.println(correctCount + "개 맞춤!");
		
//		맞춘 갯수에 따른 등수 출력
		
		if (correctCount == 6) {
			System.out.println("1등");
		}
		else if (correctCount == 5) {
//			보너스번호를 맞췄는지? 추가 검사 필요.
			
			System.out.println("임시 - 3등");
		}
		else if(correctCount == 4) {
			System.out.println("4등");
		}
		else if(correctCount == 3) {
			System.out.println("5등");
		}
		else {
			System.out.println("낙첨");
		}
		
	}

}
