import java.util.*;


public class Example {
	public static void main (String[] args){
		
		GraphEx graph = new GraphEx();
		
		City berlin = new City("Berlin", 3575000);
		City braunschweig = new City("Braunschweig", 251364);
		City bremen = new City("Bremen", 557464);
		City hannover = new City("Hannover", 532163);
		City leipzig = new City("Leipzig",560472 );
		City muenchen = new City("Muenchen", 1450000);
		City augsburg = new City("Augsburg",286374);
		City nuernberg = new City("Nuernberg", 509975);
		City erfurt = new City("Erfurt",210118);
		City frankfurt = new City("Frankfurt", 736414);
		City stuttgart = new City("Stuttgart", 628032);
		City mannheim = new City("Mannheim", 305780);
		City freiburg = new City("Freiburg", 227590);
		City mainz = new City("Mainz", 209779);
		City koeln = new City("Koeln", 1061000);
		City duesseldorf = new City("Duesseldorf", 612178);
		City weimar = new City ("Weimar", 65542);
		City krefeld = new City("Krefeld", 225144);
		City dortmund = new City("Dortmund", 585813);
		City essen = new City("Essen", 582624);
		City gotha = new City("Gotha", 45928);
		
		graph.addCity(berlin, braunschweig); // adds Berlin to the map with a direct connection to Braunschweig
		graph.addCity(hannover, braunschweig);
		graph.addCity(leipzig, berlin);
		graph.addCity(braunschweig, bremen);
		graph.addCity(bremen, dortmund);
		graph.addCity(essen,dortmund);
		graph.addCity(dortmund, hannover);
		graph.addCity(duesseldorf, koeln);
		graph.addCity(koeln, krefeld);
		graph.addCity(krefeld, duesseldorf);
		graph.addCity(frankfurt, koeln);
		graph.addCity(mainz, koeln);
		graph.addCity(gotha, erfurt);
		graph.addCity(erfurt, leipzig);
		graph.addCity(weimar, leipzig);
		graph.addCity(nuernberg, weimar);
		graph.addCity(mannheim, mainz);
		graph.addCity(muenchen, freiburg);
		graph.addCity(augsburg, muenchen);
		graph.addCity(stuttgart, freiburg);
		graph.addCity(freiburg, mannheim);
		graph.addCity(freiburg, mannheim); //throws error because Freiburg already exists in the graph
		
		graph.addConnection(essen, duesseldorf);
		graph.addConnection(mainz, frankfurt);
		graph.addConnection(frankfurt, gotha);
		graph.addConnection(nuernberg, augsburg);
		graph.addConnection(nuernberg, muenchen);
		graph.addConnection(nuernberg, frankfurt);
		graph.addConnection(nuernberg, stuttgart);
		graph.addConnection(frankfurt, mannheim);
		graph.addConnection(mannheim, stuttgart);
		graph.addConnection(augsburg, stuttgart); 
		graph.addConnection(augsburg, stuttgart); //throws error because there already is a direkt connection 
												  //between Augsburg & Stuttgart
		
		
		graph.removeCity(augsburg); //sollte augsburg und alle seine verbindungen löschen
		
		System.out.println("Hannover: ");
		hannover.printNeigh(); //prints Hannover's Neighbours
		System.out.println();
		hannover.printNode(); //prints Hannover's information
		System.out.println();
		
		System.out.println("Map of Germany: ");
		System.out.println();
		graph.printGraph(); //prints whole graph (without mainz because it has been deleted in line 68)
		
		
		
	}
}
