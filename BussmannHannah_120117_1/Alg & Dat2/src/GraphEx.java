import java.util.*;

public class GraphEx {
	
	Map<String, City> map = new HashMap<String, City>();
	
	public GraphEx(){
		this.map = new HashMap();
	}
	
	public boolean doesNodeExist(City c){
		for (Map.Entry<String, City> entry : map.entrySet()) {
			if (entry.getKey()==c.getName()){
				return true;
			}
		}
		return false;
	}
	
	
	public void addConnection(City start, City dest){
		//if ((doesNodeExist(start) == false)||(doesNodeExist(dest) == false)){
		if ((start.getNeighbours().contains(dest)== false )&&(dest.getNeighbours().contains(start)== false)){
			start.addNeighbour(dest);
			dest.addNeighbour(start);
		}
	}

	public void addCity(City c , City n){
		if(doesNodeExist(c) == false){
				map.put(c.getName(), c);
				addConnection(c, n);
				//addConnection(n, c);
		}	
		else{
			System.out.println("Error - The City " + c.getName() + " already exists!");
		}
	}	
	
	public City getCity(String name){
		if(map.containsKey(name)){
			return map.get(name); 
		}
		else{
			return map.get(name);
		}
	}
	
	public void removeCity(City c){
		if (map.containsKey(c.getName())){ //makes sure the City c exists in the graph
			map.remove(c.getName()); // deletes c from the graph
			for (Map.Entry<String, City> entry : map.entrySet()) { //itterate through the graph -> every city in it
				ArrayList<Edge> edgesToDelete = new ArrayList<Edge>();
				for (Edge e : entry.getValue().getNeighbours()){ //itterates through the list of direct connections of every city
					
					if ((c.getName().equals(e.getStart().getName()))||(c.getName().equals(e.getDestination().getName()))){
						edgesToDelete.add(e);
					}
				}
				entry.getValue().getNeighbours().remove(edgesToDelete);
			}
		}
	}
	
	public void printGraph(){
		for (Map.Entry<String, City> entry : map.entrySet()) { //interrates through the whole graph and prints every entry(=every city and its information)
			System.out.println(entry.getKey() + " " );
			System.out.println("Population: " + entry.getValue().getPopulation()+ " " );
			entry.getValue().printNeigh();
			System.out.println(" ");
		}
	}
}

