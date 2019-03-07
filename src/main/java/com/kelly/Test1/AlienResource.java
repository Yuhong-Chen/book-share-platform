package com.kelly.Test1;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")

public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAlien() {
		
		System.out.print("calling");
		return repo.getAliens();
	}

}
