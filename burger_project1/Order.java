package burger_project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	
		Scanner choice = new Scanner(System.in);
		int pick;
		ArrayList list = new ArrayList();
		CustomerVO cvo = new CustomerVO();
		
		/////////////주문?
		public void start() {
			System.out.println("주문? 1");
			
			pick = choice.nextInt();
			choice.nextLine();
		
			if(pick == 1) {		
				whereEat();
			} else if (pick != 1) {  //다른 수를 입력 할 경우에는 계속해서 초기화면을 보여주기 위해 자기자신을 호출
				start();
			}
		}
		
		////////////매장 or 테이크아웃?
		public void whereEat() {
			System.out.println("어디서 드시겠습니까?");
			System.out.println("1.매장 2.테이크아웃 3.처음으로");
			
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) { //직원에게 전달
				cvo.setWhereEat("매장");
			} else if (pick == 2) { //직원에게 전달
				cvo.setWhereEat("테이크아웃");
			} else if (pick == 3) {
				start();
			} else {
			System.out.println("다시 선택해주세요.");
			whereEat();
			}
			whatMenu();
		}
		
		////////////무슨 메뉴?
		public void whatMenu() {
			System.out.println("1:버거단품 2:음료 3:디저트 4:세트 5:이전으로 6:처음으로 7:결제하기");
			
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {			
				whatBg();
			} else if (pick == 2) {
				whatDk();
			} else if (pick == 3) {
				whatDs();
			} else if (pick == 4) {
				whatSet();
			} else if (pick == 5) {
				whereEat();
			} else if (pick == 6) {
				start();
			} else if (pick == 7) {
				whereCheck();
			} else {
				System.out.println("다시 선택해주세요.");
				whatMenu();
				
			}
		}
		
		//버거 선택시
		public void whatBg() {
			System.out.println("무슨버거?");
			System.out.println("1.치즈버거 2.더블치즈버거");

			pick = choice.nextInt();
			choice.nextLine();
			
			//버거선택if
			if(pick == 1) {	
				cvo.setWhatBg("치즈버거");
				//장바구니에 저장
			} else if (pick == 2) {
				cvo.setWhatBg("더블치즈버거");
				//장바구니에 저장
			}
			
			System.out.println("원하시는 구성을 선택해주세요");
			System.out.println("1단품,2세트,라지세트");

			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {
				//버거 종류에 따른 세트로
				whatMenu();
				//장바구니에 저장
			} else if (pick == 2) { //일반세트
				whatDk();
				//장바구니에 저장
			} 
		}
		
		//세트선택시
		public void whatSet() {
			System.out.println("무슨세트?");
			System.out.println("1치즈세트,2더블치즈세트");
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {
				System.out.println("치즈세트");
				cvo.setWhatBg("치즈버거");
				whatDk();
			} else if (pick == 2) {
				System.out.println("더블치즈세트");
				whatDk();
			}
			
			//if
		}
		//음료선택시
		public void whatDk() {
			System.out.println("무슨음료?");
			System.out.println("1콜라,2사이다");
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {
				System.out.println("콜라");
				cvo.setWhatDk("콜라");
				whatMenu();
			} else if (pick == 2) {
				System.out.println("사이다");
				cvo.setWhatDk("사이다");
				whatMenu();
			}
		}
		//디저트선택시
		public void whatDs() {
			System.out.println("무슨디저트?");
			System.out.println("1아이스크림,2윙");
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {
				System.out.println("아이스크림");	
				cvo.setWhatDs("아이스크림");
				whatMenu();
			} else if (pick == 2) {
				System.out.println("윙");
				cvo.setWhatDs("윙");
				whatMenu();
			}
			//if
		}
		
		//어디에서 결제?
		public void whereCheck() {
			System.out.println("어디서 결제하시겠습니까?");
			System.out.println("1카운터,2가게");
			pick = choice.nextInt();
			choice.nextLine();
			
			if(pick == 1) {			
				System.out.println("카운터");
				cvo.setWhereCheck("카운터");
			} else if (pick == 2) {
				System.out.println("기계");
				cvo.setWhereCheck("가게");
			}
			pirntBill();
		}
		
		public void pirntBill() {
			System.out.println("영수증");
			System.out.println(cvo);
			
			pick = choice.nextInt();
			choice.nextLine();	
		}
		
		
		
		
}
