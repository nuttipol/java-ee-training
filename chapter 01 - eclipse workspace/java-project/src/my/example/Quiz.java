package my.example;

public class Quiz {
	
	public static void main(String[] args) {
		Quiz.printStar(5);
	}
	
	public static void printStar(int x) {
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= x; j++) { 
				for (int k = 1; k <= j*i; k++) {
					System.out.print("*");
					if(j<(i*j) && (k%j==0) && (j!=x) && (k < j*i)) {
						for (int l = 1; l <= (x-j); l++) {
							System.out.print(" ");
						}
					}
				} 
				System.out.println("");	
			}
		}
	}
}
