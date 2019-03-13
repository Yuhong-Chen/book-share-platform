package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import com.wenzhe.Bookserver.UserResource;
import com.wenzhe.bean.user;

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
        user entity = target("/user/1").request().get(user.class);
        assertEquals("userName: ", "Kelly", entity.getUserName());
        assertEquals("passWord: ", "123", entity.getUserPwd());
    }


    @Test
    public void PostAlienTest() {
    	 user user = new user();
    	    user.setUserName("yuhong");
    	    user.setUserPwd("1314520");
    	    user.setId(5);
    	    Entity<user> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);
         target("/user/create").request().post(userEntity);
         user entity = target("/user/5").request().get(user.class);
         assertEquals("userName: ", "yuhong", entity.getUserName());
         assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }

    @Test
    public void putAlienTest() {
    	user user = new user(3,"chen","1314520");
 	    Entity<user> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);
      target("/user/update/3").request().put(userEntity);
      user entity = target("/user/3").request().get(user.class);
      assertEquals("userName: ", "chen", entity.getUserName());
      assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }


}

