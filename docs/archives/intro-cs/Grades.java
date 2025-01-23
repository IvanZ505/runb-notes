

public class Grades {
	
	public static void main(String[] args){
		int students = Integer.parseInt(args[0]);
		int assignments = Integer.parseInt(args[1]);

		double[][] scores = new double[students][assignments];
		
		int i;
		for(i=0; i< scores.length; i++) {
			int j;
			for(j=0; j<scores[i].length; j++) {
				scores[i][j] = Math.random()*10;
				System.out.print("%f ",scores[i][j]);
			}
			System.out.println();
		}
}
}
