package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import Player.Pirate;

public class GameMap {
	
	public int[][] map;
	public int width, height;
	private int[] xDir = {-1,1,-1,1,0,1,0,-1};
	private int[] yDir = {-1,-1,1,1,-1,0,1,0};
	public Pirate player;
	
	public GameMap(){
		readMap("lvl1.txt");
		discover();
		drawMap();
	}
	
	private void readMap(String path){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(this.getClass().getResource("/Levels/" + path).toURI())));
			String s = br.readLine();
			String[] a = s.split(" ");
			
			int w=Integer.parseInt(a[0]);
			int h=Integer.parseInt(a[1]);
			map = new int[h][w];
			width=w;
			height=h;
			s=br.readLine();
			for(int row=0;row<h;row++){
				String[] d = s.split(" ");
				for(int i = 0; i < d.length; i++){
					int act = Integer.parseInt(d[i]);
					map[row][i] = act;
					if(act == -5){ //-5 = player
						player = new Pirate(row, i, 100, 250);
						
					//	this.robot.setLocation(row, i);
					}
				}
				s = br.readLine();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			
		}
	}
	
	private void discover(){
		int x = player.x;
		int y = player.y;
		for(int i=0;i<xDir.length;i++){
			int newX = x+xDir[i];
			int newY = y+yDir[i];
			if(newX >=0 && newY >=0 && newX<width && newY<height){
				if(map[newX][newY]>0){
					map[newX][newY]*=-1;
				}
			}
		}
	}
	
	
	private void drawMap(){
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
