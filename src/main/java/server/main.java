package server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class main {
	
	public static final String BASE_URI = "http://localhost:8080/bookserver/webapi/";

	  /**
	   * Starts the Server.
	   * @return HTTP Server
	   */
	  public static HttpServer startServer() {
	    // create a resource config that scans for JAX-RS resources and providers
	    final ResourceConfig rc = new ResourceConfig().packages("server.bookserver");

	    // create and start a new instance of grizzly http server
	    // exposing the Jersey application at BASE_URI
	    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	  }

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub

		final HttpServer server = startServer();
	    System.out.println(String.format("Jersey app started with WADL available at "
	          + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
	    System.in.read();
	    //server.stop();
	}

}
