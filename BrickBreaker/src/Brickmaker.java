
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brickmaker {
	
	public int pic[][];
	public int bw;
	public int bh;
	
	public Brickmaker(int row, int column){
		
		pic = new int[row][column];
		//nested loop for creating breaks
		for(int i=0;i<pic.length;i++) {
			for(int j=0;j<pic[0].length;j++) {
				pic[i][j] = 1;
				
				
				
				
			}
			
			
		}
		
		bw = 490/column;//490/7=70
		bh = 160/row;//160/4=40
		
		
	}
	
	public void draw(Graphics2D g) {
		//nested loop for filling it
		for(int i=0;i<pic.length;i++) {
			for(int j=0;j<pic[0].length;j++) {
				if(pic[i][j]==1) {//in the above code when map[i][j]=1 is it will be filled, white&green colorful bricks
					if(i%2==0&&j%2==0) {
					g.setColor(Color.WHITE);
					g.fillRect(j*bw+70, i*bh+40, bw, bh);
					g.setStroke(new BasicStroke(3));// for the distinction of bricks
					g.setColor(Color.black);
					g.drawRect(j*bw+70, i*bh+40, bw, bh);
					}else {
						g.setColor(Color.GREEN);
						g.fillRect(j*bw+70, i*bh+40, bw, bh);
						g.setStroke(new BasicStroke(3));// for the distinction of bricks
						g.setColor(Color.black);
						g.drawRect(j*bw+70, i*bh+40, bw, bh);
					}
					
				}
				
				
				
			}
			
			
		}
		
		
	}
	
	public void setBrickValue(int value, int row, int col) {
		pic[row][col] = value;
		
	}

}