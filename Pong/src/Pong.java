import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends Frame 
{
	
	int ballX = 375, ballY = 275;   //position of the ball object
	int speedX = 10, speedY = 10; //movement
	Color ballColor = new Color(10,200,10);
	
	int rpx = 780, rpy = 400;
	int lpx = 10, lpy = 400;
	int lpxx = 10, lpyy = 400;
	int pW = 10;
	int pH = 100;
	Color pColor = new Color (100,100,100);
	
	int playerScore1 = 0;
	int playerScore2 = 0;
	
	
/* paint is getting called roughly 60x per second */
	public void paint(Graphics g) 
{
		super.paintComponent(g);
		
//paint the pong ball
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		Font biggerFont = new Font("serif", Font.PLAIN, 50);
		g.setFont(biggerFont);
		g.setColor(Color.white);
		g.drawString(""+playerScore1, 150 ,50);
		g.drawString(""+playerScore2, 600 , 50);
		
		
		
		
		g.setColor(Color.white); 
		g.fillOval(ballX, ballY, 50,50);
		ballX = ballX +speedX;
		ballY += speedY;
		
		g.setColor(Color.green); 
		g.fillRect(lpx, lpy, pW, pH); //left paddle blue ws
		g.setColor(Color.blue); 
		g.fillRect(lpxx, lpyy, pW, pH); //left paddle green arrow up down
		g.setColor(Color.red); 
		g.fillRect(rpx, ballY - 12, pW, pH); //right paddle red ai
		
		
	
		
		if(ballX >= 750) {
			playerScore1++;
		}
		if(ballX <= 0) {
			playerScore2++;
		}
		

		if(ballY >=550 || ballY <=0 ) 
		{
					speedY *= -1.05;
		}
		
		if(ballX >= 750 || ballX <= 0) 
{
			ballX = 375;
			ballY = 275;
			
			speedX = (int)(Math.random()*(15-1+1))+5;
			if(Math.random()<.50) {
			speedX = -speedX; }
			speedY = (int)(Math.random()*(15-1+1))+5;
			if(Math.random()<.50) {
			speedY = -speedY; }

}
	//left paddle collision	
		
		if(ballX <=(lpx + 15) && ballY +25 >= (lpy+5) && ballY <= (lpy + 80) && speedX <0){
			speedX *=-1;
		
		
			;
		}else if(ballX <=(lpxx + 15) && ballY +25 >= (lpyy+5) && ballY <= (lpyy + 80) && speedX<0){
			speedX *=-1;
			
		}//end of if
		
		if((ballX+50) >= rpx && (ballX+50) <=(rpx + 10)){
			speedX *=-1;
			
		}//end of if
		
		
		
		if(lpy>500) { //teleport to other side
			lpy =0;
		}
		if(lpy<0) {
			lpy =500;
		}
		if(lpyy>500) {
			lpyy =0;
		}
		if(lpyy<0) {
			lpyy =500;
		}
		
}//end of paint method

	
			
	
	public void keyPressed(KeyEvent key) 
{
		System.out.println(key.getKeyCode());
		if(key.getKeyCode() == 83) {
			// 83 is s
			lpy +=60;
		}
		if(key.getKeyCode() == 87) {
			// 87 is w
			lpy -=60;
		}
		if(key.getKeyCode() == 40) {
			// 38 is down
			lpyy +=60;
		}
		if(key.getKeyCode() == 38) {
			// 40 is up
			lpyy -=60;
		}
		
		
}


	public void keyReleased(KeyEvent arg0) 
{
		
		
}


	public void keyTyped(KeyEvent arg0) 
{
		
		
}
	public static void main(String[] arg) 
{
		Pong p = new Pong();
		
		
		
		
		
		
		
		
		
		
}
	
}
