package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
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
        user entity = target("/users/1").request().get(user.class);
        assertEquals("userName: ", "Kelly", entity.getUserName());
        assertEquals("passWord: ", "123456", entity.getUserPwd());
    }


    @Test
    public void getAliensTest() {
        Response response = target("/users").request().get();
        assertTrue(response.readEntity(String.class).equals("returned all users"));
    }


    @Test
    public void PostAlienTest() {
        Response response = target("/users/create").request()
                .post(Entity.json("{\"username\":\"Yuhong Chen\",\"userpwd\":1314520}"));
        assertTrue(response.readEntity(String.class).equals("add to the database"));
    }


    @Test
    public void putAlienTest() {
        Response response = target("/update/1").request()
                .put(Entity.json("{\"username\":\"Yuhong Chen\",\"userpwd\":1314520}"));
        assertTrue(response.readEntity(String.class).equals("update to the database"));

    }


    @Test
    public void deleteAlienTest() {

        Response response = target("/delete/1").request()
                .delete();
        assertTrue(response.readEntity(String.class).equals("deleted in the database"));
    }



}

