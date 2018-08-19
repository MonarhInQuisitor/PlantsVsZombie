package pz;

public class Matrix {
	private int x = MainApp.wcount;
	private int y = MainApp.hcount;
	private boolean[][] mat = new boolean[x][y];

	public void CreatMatrix() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				mat[i][j] = true;
			}
		}
	}
	
	public boolean isFree(double x, double y) {
		return mat[transformX(x)][transformY(y)];

}
	public void add(double x, double y) {
		mat[transformX(x)][transformY(y)]=false;
	}
	public void remove(double x, double y) {
		mat[transformX(x)][transformY(y)]=true;
	}
	
	private int transformX(double x) {
		if (((int) x) / 66 > 0) {
			return (((int) x) / 66) ;
		} else
			return 0;
		
	}
	private int transformY(double y) {
		if (((int) y) / 50 > 0) {
			return (((int) y) / 50);
		} else
			return 0;
		
	}

}
