package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.Iterator;
 

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;



 

 
/**
 * Loads a map from a .json file.
 *
 */
public abstract class MapLoader {

    private JSONObject json;
   
    

    public MapLoader(String filename) throws FileNotFoundException {
    	
        json = new JSONObject(new JSONTokener(new FileReader("src/application/" + filename)));
        //json = new JSONObject(new JSONTokener(new FileReader(filename)));
        //System.out.println("goal is " + json);
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public MapOfRobot load() {
        int width = json.getInt("width");
        int height = json.getInt("height");
         
        
        //JSONObject goal = json.getJSONObject("goal-condition");
        //System.out.println("goal is " + goal.toString());

        MapOfRobot mapOfRobot = new MapOfRobot(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");
        
     // System.out.println("goal is " + jsonEntities);

        for (int i = 0; i < jsonEntities.length(); i++) {
        	
            loadEntity(mapOfRobot, jsonEntities.getJSONObject(i));
            //System.out.println("duixiang ni shi shen em  " +jsonEntities.getJSONObject(i).toString());
        }  
//        System.out.println("duixiang ni shi shen em  " +mapOfRobot.getEntities());
       
        return mapOfRobot;
    }

    private void loadEntity(MapOfRobot mapOfRobot, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");
           	
        Entity entity = null;
        switch (type) {
        case "player":
        	Roboter roboter = new Roboter(mapOfRobot, x, y);
        	mapOfRobot.setPlayer(roboter);
        	roboter.setName("roboter 1");
            onLoad(roboter);
            entity = roboter;            
            break;  
//        case "enemy":
//        	 
//        	break;
//        	       
        
        default:      	
        	break;
        }
        
        mapOfRobot.addEntity(entity);
        
        
    }

    public abstract void onLoad(Entity player);

//    public abstract void onLoad(Wall wall);
//    
//    public abstract void onLoad(Exit exit);
//    
//    public abstract void onLoad(Invincibility invincibility);
//    
//    public abstract void onLoad(Bomb bomb);
//    
//    public abstract void onLoad(Sword sword);
//    
//    public abstract void onLoad(Treasure  treasure);
//    
//    public abstract void onLoad(Enemy  enemy);
//    
//    public abstract void onLoad1(Enemy enemy);
    
 
    
//    
//    public abstract void onLoad(BombSecend1  bombSecend1);
//    
//    public abstract void onLoad(BombSecend2  bombSecend2);
//    
//    public abstract void onLoad(BombSecend3  bombSecend3);
   

    // TODO Create additional abstract methods for the other entities

}
