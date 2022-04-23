import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		
				JFrame obj = new JFrame();
				BBGame game = new BBGame();
				obj.setBounds(10, 10, 640, 560);
				obj.setTitle("Brick Breaker");
				obj.setResizable(false);

				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.add(game);
				obj.setVisible(true);
				
				JFrame fr= new JFrame();
				fr.setBounds(800,100,500,300);
				fr.setTitle("Instructions");
				fr.setVisible(true);
				JPanel p= new JPanel();
				JLabel l= new JLabel("Use A and K keys for faster paddle");
				JLabel l2= new JLabel("Use arrow keys for normal paddle");
				JLabel l3= new JLabel("After finishing 1st level release button2+space for next level");
				JLabel l4= new JLabel("After finishing 2nd level release button3+space for next level");
				JLabel l5= new JLabel("After finishing 3rd level release button4+space for next level");
				JLabel l6= new JLabel("For start click the Frame of game");
				JLabel l7= new JLabel("then press arrow key or a,d");
				JLabel l8= new JLabel("Good luck!");
				fr.add(p);
				p.add(l);
				p.add(l2);
				p.add(l3);
				p.add(l4);
				p.add(l5);
				p.add(l6);
				p.add(l7);
				p.add(l8);

	}

}
