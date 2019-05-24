//These are the Nodes 
import java.util.*;

public class City {
	private String name;
	private int population;
	private ArrayList<Edge> neighbours = new ArrayList<Edge>();
	
	public City(String name) {
		this.name = name;
		this.population = 0;
	}
	
	public City(String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public int addNeighbour(City neigh){
		for (int i = 0; i < neighbours.size(); i++){
			if (neighbours.get(i).getDestination().getName().equals(neigh.getName())){
				System.out.println("Error - " + neigh.getName() + " is already " + this.getName() + "'s neighbour ");
				return -1;
			}
		}
		Edge e = new Edge(this, neigh);
		neighbours.add(e);
		return 1;		
	}

	public void removeConnection(City c){
		for (int i = 0; i < getNeighbours().size(); i++){
			Edge e = (Edge)getNeighbours().get(i); 
			if (e.getStart().getName().equals(c.getName())){
				neighbours.remove(i);
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	public ArrayList<Edge> getNeighbours() {
		return neighbours;
	}
	
	public void printNode(){
		System.out.println("* " + name + "* ");
		System.out.println("- Population:  " + population);
	}
	public void printNeigh(){
		System.out.println("direct connections: ");
		for (int i = 0; i < neighbours.size();i++){	
			neighbours.get(i).getDestination().printNode();
			//System.out.print(" " + neighbours.get(i) + " ");
			
		}
	}
}
	

