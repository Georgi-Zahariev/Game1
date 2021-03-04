
import java.util.Scanner;

class Game{
	private int N;
	private int Q;
	private Scanner inp = new Scanner( System.in);
	Game(int n ,int q){
	 N=n;
	 Q=q;
	}
	public void showSit(){
		System.out.println("Remaining: " + N + " at least 1 , no more than " + Q);
	}
	public void playerMove(){
		int a;
		do{
			System.out.print("Input your move: ");
			a = inp.nextInt();
		}while( a<1 || a>Q || a>N );
		N-=a;
	}
	public void compMove(){
		int t = N%(Q+1),p;
		if( t==0) p=1;
		else p=t;
		System.out.println(" I taka: " + p );
		N-=p;
	}
	public void play(){
		char ans;
		int who = 2;
		do{
		System.out.println("Do you want to play first (Y/N): ");
		ans=inp.next().charAt(0);
		}while( ans != 'Y' && ans != 'y' &&ans != 'N' &&ans != 'n'  );
		
		if( ans=='n' || ans=='N'){
			who=2;
			showSit();
			compMove();
		}
		while( N!=0){
			showSit();
			who=1;
			playerMove();
			if(N==0){break;}
			who=2;
			compMove();
		}
		if( who==1) System.out.println("You win!");
		else System.out.println("I (awlays) win!");
		
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Game q = new Game( 10,3);
      q.play();
	}

}
