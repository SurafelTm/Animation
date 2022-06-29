package chap3G;
//Surafel Tesfamichael
// CSC 142
import java.awt.*;

public class Animation {
//Use global final/constants for the 
//DrawingPanel and Graphics objects
//to avoid having to pass them as parameters.
	public static final DrawingPanel P = new DrawingPanel(800,600);
	public static final Graphics G = P.getGraphics();

	public static void main(String[] args) {
		P.setBackground(Color.gray);
		drawanimation();// draw the whole animation 
	}
	public static void drawanimation() {
		for(int i=1; i<=120; i++) {
			P.clear();
			drawroad();// draw the road
			buildings(50,200,105,350);// draw the smallest building twice
			buildings(180,100,90,450);// draw the largest building twice
			if(i%2==0) {
				G.setColor(Color.green);
			}
			else {
				G.setColor(Color.red);
			}
			drawlightsbldg(10,35,15,200,50,165,155); // draw the lights on the bldg and change them using for loop
			if(i%2==0) {
				G.setColor(Color.yellow);
			}
			else {
				G.setColor(Color.cyan);
			}
			drawlightsbldg(15,30,150,100,180,70,270);// draw the lights on the bldg2 and change them using for loop
			drawcar(i); // draw the first car and move it from right to left
			drawcars(Color.white,i,1380,1320,1290,1330,1310,1);// draw the second car and move it from right to left and pass over the first car
			drawcars(Color.blue,i,-230,-290,-240,-330,-260,-1);// draw the third car and move it from left to right
			drawplane(i);// draw plane at the top and flying to east 
			P.sleep(100);		
	     }
	}
	public static void drawroad() {
		G.setColor(Color.DARK_GRAY);
		G.fillRect(0,550,800,50);
	}
	public static void buildings(int x0, int y0, int dx , int dy) { //use for loop to draw four buildings
		for(int k=1; k<=2; k++) {
			G.setColor(Color.DARK_GRAY);
			G.fillRect(x0+(300*k-300),y0,dx,dy);
		}
	}
	public static void drawlightsbldg(int n, int m, int b, int y0,
			 int x0, int b2, int dx) {	
		for(int k=1; k<=2; k++) {
			for(int i=1; i<=4; i++) {
				G.drawLine(b+m*i+(300*k-300),y0,b+m*i+(300*k-300),550);	
		     }
		
			for(int j=1; j<=n; j++) {
				G.drawLine(x0+(300*k-300),b2+m*j,dx+(300*k-300),b2+m*j);
			}
		}
	}
	public static void drawcar(int y) { // draw and moves the first car
		G.setColor(Color.black);
	    G.fillOval(900-10*y, 520, 30, 30);
	    G.fillOval(830-10*y, 520, 30, 30);
	    G.setColor(Color.red);
	    G.fillRect(830-10*y,470,120,50);
	    G.fillRect(810-10*y,480,20,40);
	}
	public static void drawcars(Color c, int z, int o1, int o2, int o3, int r1, int r2, int f) {
		//draw two cars with different color and different directions 
		G.setColor(Color.black);
		G.fillOval(o1-f*20*z, 530, 20, 20);
		G.fillOval(o2-f*20*z, 530, 20, 20);
		G.setColor(c);
		G.fillOval(o3-f*20*z,480,50,50);
	    G.fillRect(r1-f*20*z,500,100,30);
	    G.fillRect(r2-f*20*z,480,50,50);
	}
	public static void drawplane(int w) {
		// draw plane and moves from top left to right
		G.setColor(Color.white);
		
		Polygon poly = new Polygon();
		// uses polygon to draw the body parts of the plane
		// we can avoid the redundancy but since the values are not same pattern it 
		// becomes more complicated and this one is more clear and precise
		for(int i=1; i<=2; i++) {
		   poly.addPoint(160+(10*w),150*i-140);
		   poly.addPoint(160+(10*w),80);
		   poly.addPoint(195+(10*w),80);
		   G.fillPolygon(poly);
		}
		Polygon poly2 = new Polygon();
		    G.setColor(Color.green);
			poly2.addPoint(20+(10*w),30);
			poly2.addPoint(80+(10*w),95);
			poly2.addPoint(20+(10*w),55);
			G.fillPolygon(poly2);
		Polygon poly3 = new Polygon();
		    G.setColor(Color.yellow);
			poly3.addPoint(20+(10*w),55);
			poly3.addPoint(80+(10*w),95);
			poly3.addPoint(20+(10*w),80);
			G.fillPolygon(poly3);
		Polygon poly4 = new Polygon();
		    G.setColor(Color.red);
			poly4.addPoint(20+(10*w),80);
			poly4.addPoint(80+(10*w),95);
			poly4.addPoint(20+(10*w),95);
			G.fillPolygon(poly4);
		G.setColor(Color.white);
		G.fillOval(60+(10*w), 60, 180, 50);
	}
}
