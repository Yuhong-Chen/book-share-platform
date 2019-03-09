package com.kelly.Test1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")

public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		
		System.out.print("calling");
		return repo.getAliens();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien alien) {
		//System.out.println(alien);
		repo.create(alien);
		System.out.println("finish create");
		return alien;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alien updateAlien(@PathParam("id") int id,Alien alien) {
		repo.update(id,alien);
		System.out.println("update successful");
		return alien;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAlien(@PathParam("id") int id) {
		repo.delete(id);
		System.out.print("delete successful");
	}
	
	
}
