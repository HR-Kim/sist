package sutdaProject.DAO;

import java.util.Scanner;

import sutdaProject.DTO.sutdaCard;

public class PlayGame {
	public final int CARD_NUM = 20;
	private sutdaCard[] cards = new sutdaCard[CARD_NUM];
	public PlayGame() {
		sutdaDeck();
	}
	
	public void play(){
		SingletonClass singleton = SingletonClass.getInstance();
		Scanner sc = new Scanner(System.in);
		
		sutdaCard[] userCard = new sutdaCard[2];
		sutdaCard[] comCard = new sutdaCard[2];
		int continu;
		int betMoney = 1;
		int totBetMoney;
		int totComBetMoney;
		int comDecison;
		
		shuffle();
		
		userCard[0] = cards[0];
		comCard[1] = cards[1];
		userCard[1] = cards[2];
		comCard[1] = cards[3];
		
		System.out.println("당신의 패는 " + cards[0].toString() + "과" + cards[2].toString() + "입니다.");
		int i=0;
		totBetMoney = 1000;
		totComBetMoney = 0;
		while(true){
			System.out.println("배팅 가능한 금액 : " + (singleton.onGameHu.getMoney()-totBetMoney));
			if(i==0){
				System.out.print("배팅하시겠습니까? (1-콜 2-다이) : ");
				continu = sc.nextInt();
				if(continu == 1){
					System.out.print("얼마를 거시겠습니까? (0 -체크)  :");
					betMoney = sc.nextInt();
					if(betMoney == 0){
						comDecison = ((int)(Math.random()*20)+1)%8;
						if(comDecison == 0){
							if(userCard[0].isKwang() && userCard[1].isKwang()){
								System.out.println("승리!!");
								singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
								break;
							}else{
								if(userCard[0].getNum() == userCard[1].getNum()){
									if(comCard[0].isKwang() && comCard[1].isKwang()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else if(comCard[0].getNum() == comCard[1].getNum()){
										if(userCard[0].getNum() > comCard[0].getNum()){
											System.out.println("승리!!");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
											break;
										}else{
											System.out.println("패배...");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
											break;
										}
									}else{
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}
								}else{
									if(comCard[0].isKwang() && comCard[1].isKwang()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else if(comCard[0].getNum() == comCard[1].getNum()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else{
										int userSum = userCard[0].getNum() + userCard[1].getNum();
										int comSum = comCard[0].getNum() + comCard[1].getNum();
										if(userSum > comSum){
											System.out.println("승리!!");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
											break;
										}else if(userSum == comSum){
											System.out.println("무승부!!");
											i=0;
											shuffle();
											System.out.println("카드 재분배");
											userCard[0] = cards[0];
											comCard[1] = cards[1];
											userCard[1] = cards[2];
											comCard[1] = cards[3];
										}else{
											System.out.println("패배...");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
											break;
										}
									}
								}
							}
						}else{ //받고 더!
							betMoney = ((int)(Math.random()*10)+1) * 1000;
							totComBetMoney += betMoney;
							++i;
							continue;
						}	
					}else{
						totBetMoney += betMoney;
						if(totBetMoney > singleton.onGameHu.getMoney()){
							System.out.println("가진 돈보다 배팅금액이 더 높습니다.");
							totBetMoney -= betMoney;
							continue;
						}
						comDecison = ((int)(Math.random()*20)+1)%8;
						
						if(comDecison == 0){ //컴퓨터 콜!
							if(userCard[0].isKwang() && userCard[1].isKwang()){
								System.out.println("승리!!");
								singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
								break;
							}else{
								if(userCard[0].getNum() == userCard[1].getNum()){
									if(comCard[0].isKwang() && comCard[1].isKwang()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else if(comCard[0].getNum() == comCard[1].getNum()){
										if(userCard[0].getNum() > comCard[0].getNum()){
											System.out.println("승리!!");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
											break;
										}else{
											System.out.println("패배...");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
											break;
										}
									}else{
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}
								}else{
									if(comCard[0].isKwang() && comCard[1].isKwang()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else if(comCard[0].getNum() == comCard[1].getNum()){
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}else{
										int userSum = userCard[0].getNum() + userCard[1].getNum();
										int comSum = comCard[0].getNum() + comCard[1].getNum();
										if(userSum > comSum){
											System.out.println("승리!!");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
											break;
										}else if(userSum == comSum){
											System.out.println("무승부!!");
											i=0;
											shuffle();
											System.out.println("카드 재분배");
											userCard[0] = cards[0];
											comCard[1] = cards[1];
											userCard[1] = cards[2];
											comCard[1] = cards[3];
										}else{
											System.out.println("패배...");
											singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
											break;
										}
									}
								}
							}
						}else if(comDecison == 1){ //컴퓨터 받고 더!
							betMoney = ((int)(Math.random()*10)+1) * 1000;
							totComBetMoney += betMoney;
							++i;
							continue;
						}else{
							System.out.println("상대편 다이!");
							singleton.onGameHu.setMoney(singleton.onGameHu.getMoney() + totBetMoney);
							break;
						}
					}
					
				}else if(continu == 2){
					System.out.println("다이...");
					singleton.onGameHu.setMoney(singleton.onGameHu.getMoney() - totBetMoney);
					break;
				}else {
					System.out.println("1과 2중에서 고르시오!");
					continue;
				}
			}
			else{
				if(totComBetMoney != 0){
					System.out.print("상대가" + totComBetMoney + "를 불렀습니다.");
					System.out.print("배팅하시겠습니까? (1-콜 , 2-받고 더, 3-다이) :");
					continu = sc.nextInt();
					if(continu == 1){
						totBetMoney += totComBetMoney;
						if(totBetMoney > singleton.onGameHu.getMoney()){
							totBetMoney = singleton.onGameHu.getMoney();
						}
						///승부가림
						if(userCard[0].isKwang() && userCard[1].isKwang()){
							System.out.println("승리!!");
							singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
							break;
						}else{
							if(userCard[0].getNum() == userCard[1].getNum()){
								if(comCard[0].isKwang() && comCard[1].isKwang()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else if(comCard[0].getNum() == comCard[1].getNum()){
									if(userCard[0].getNum() > comCard[0].getNum()){
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}else{
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}
								}else{
									System.out.println("승리!!");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
									break;
								}
							}else{
								if(comCard[0].isKwang() && comCard[1].isKwang()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else if(comCard[0].getNum() == comCard[1].getNum()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else{
									int userSum = userCard[0].getNum() + userCard[1].getNum();
									int comSum = comCard[0].getNum() + comCard[1].getNum();
									if(userSum > comSum){
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}else if(userSum == comSum){
										System.out.println("무승부!!");
										i=0;
										shuffle();
										System.out.println("카드 재분배");
										userCard[0] = cards[0];
										comCard[1] = cards[1];
										userCard[1] = cards[2];
										comCard[1] = cards[3];
									}else{
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}
								}
							}
						}
						
					}else if(continu == 2){
						System.out.print("얼마를  더 거시겠습니까? :(가진금액보다 배팅금액을 높게 부를시 올인으로 간주!)");
						totBetMoney += totComBetMoney;
						betMoney = sc.nextInt();
						
						totBetMoney += betMoney;
						
						if(totBetMoney > singleton.onGameHu.getMoney()){
							System.out.println("올인");
							totBetMoney = singleton.onGameHu.getMoney();
						}
						
						if(userCard[0].isKwang() && userCard[1].isKwang()){
							System.out.println("승리!!");
							singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
							break;
						}else{
							if(userCard[0].getNum() == userCard[1].getNum()){
								if(comCard[0].isKwang() && comCard[1].isKwang()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else if(comCard[0].getNum() == comCard[1].getNum()){
									if(userCard[0].getNum() > comCard[0].getNum()){
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}else{
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}
								}else{
									System.out.println("승리!!");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
									break;
								}
							}else{
								if(comCard[0].isKwang() && comCard[1].isKwang()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else if(comCard[0].getNum() == comCard[1].getNum()){
									System.out.println("패배...");
									singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
									break;
								}else{
									int userSum = userCard[0].getNum() + userCard[1].getNum();
									int comSum = comCard[0].getNum() + comCard[1].getNum();
									if(userSum > comSum){
										System.out.println("승리!!");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()+totBetMoney);
										break;
									}else if(userSum == comSum){
										System.out.println("무승부!!");
										i=0;
										shuffle();
										System.out.println("카드 재분배");
										userCard[0] = cards[0];
										comCard[1] = cards[1];
										userCard[1] = cards[2];
										comCard[1] = cards[3];
									}else{
										System.out.println("패배...");
										singleton.onGameHu.setMoney(singleton.onGameHu.getMoney()-totBetMoney);
										break;
									}
								}
							}
						}
					}else if(continu == 3){
						System.out.println("다이...");
						singleton.onGameHu.setMoney(singleton.onGameHu.getMoney() - totBetMoney);
						break;
					}else {
						System.out.println("1과 2,3중에서 고르시오!");
						continue;
					}
				}
				
				
			}
			++i;
		}
		
		
		
	}
	
	private void sutdaDeck(){
		int num = 1;
		for(int i=0; i<CARD_NUM; ++i){
			if(num==1 || num == 3 || num == 8){
				cards[i] = new sutdaCard((num - 10*(num/11)), true);
			}else{
				cards[i] = new sutdaCard((num - 10*(num/11)), false);
			}
			num++;
		}
	}
	
	private void shuffle(){
		int r1, r2;
		sutdaCard temp;
		
		for(int i=0; i<100; i++){
			r1 = (int)(Math.random()*20);
			r2 = (int)(Math.random()*20);
			temp = cards[r1];
			cards[r1] = cards[r2];
			cards[r2] = temp;
		}
	}
}

