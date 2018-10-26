package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameMap {
	
	public int[][] map;
	public int width, height;
	
	public GameMap(){
		readMap("lvl1.txt");
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
					if(act == 5){
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
	private void drawMap(){
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
