package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.Iterator;
 

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import application.Model.Entity;
import application.Model.Roboter;

 
/**
 * Loads a map from a Json file.
 *
 */
public abstract class MapLoader {

    private JSONObject json;  

    public MapLoader(String filename) throws FileNotFoundException {
    	
        json = new JSONObject(new JSONTokener(new FileReader("src/application/" + filename)));
       
    }

    /**
     * Parses the JSON to create a map.     * 
     */
    public MapOfRobot load() {
        int width = json.getInt("width");
        int height = json.getInt("height");      

        MapOfRobot mapOfRobot = new MapOfRobot(width, height);
        JSONArray jsonEntities = json.getJSONArray("entities");  

        for (int i = 0; i < jsonEntities.length(); i++) {        	
            loadEntity(mapOfRobot, jsonEntities.getJSONObject(i));           
        }         
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
        	String name = json.getString("name");
        	roboter.setName(name);
        	int key = json.getInt("key");        	
        	roboter.setKey(key);  
            onLoad(roboter);
            mapOfRobot.addRobots(roboter);
            entity = roboter;            
            break;         
        default:      	
        	break;
        }        
        mapOfRobot.addEntity(entity);     
    }

    public abstract void onLoad(Entity player);

}
