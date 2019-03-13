

import static org.junit.Assert.assertEquals;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import server.Bookserver.UserResource;
import server.bean.user;

public class userResourceTest extends JerseyTest {

    public userResourceTest() {
        super();
    }


    @Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }


    @Test
    public void getAlienTest() {
        user entity = target("/user/Kelly").request().get(user.class);
        assertEquals("userName: ", "Kelly", entity.getUserName());
        assertEquals("passWord: ", "123", entity.getUserPwd());
    }


    @Test
    public void PostAlienTest() {
    	 user user = new user();
    	    user.setUserName("yuhong");
    	    user.setUserPwd("1314520");
    	    user.setId("5");
    	    Entity<user> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);
         target("/user/create").request().post(userEntity);
         user entity = target("/user/yuhong").request().get(user.class);
         assertEquals("userName: ", "yuhong", entity.getUserName());
         assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }

    @Test
    public void putAlienTest() {
    	user user = new user("3","chen","1314520");
 	    Entity<user> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);
      target("/user/update/3").request().put(userEntity);
      user entity = target("/user/chen").request().get(user.class);
      assertEquals("userName: ", "chen", entity.getUserName());
      assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }


}

