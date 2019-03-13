

import static org.junit.Assert.assertEquals;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import server.bean.User;
import server.bookserver.UserResource;

public class UserResourceTest extends JerseyTest {

    public UserResourceTest() {
        super();
    }


    @Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }


    @Test
    public void getAlienTest() {
        User entity = target("/User/Kelly").request().get(User.class);

        assertEquals("userName: ", "Kelly", entity.getUserName());
        assertEquals("passWord: ", "123", entity.getUserPwd());
    }


    @Test
    public void PostAlienTest() {
         User user = new User();
         user.setUserName("yuhong");
         user.setUserPwd("1314520");
         user.setId("5");

         Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);

         target("/User/create").request().post(userEntity);
         User entity = target("/User/yuhong").request().get(User.class);

         assertEquals("userName: ", "yuhong", entity.getUserName());
         assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }

    @Test
    public void putAlienTest() {
      User user = new User("3","chen","1314520");
      Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON_TYPE);

      target("/User/update/3").request().put(userEntity);
      User entity = target("/User/chen").request().get(User.class);

      assertEquals("userName: ", "chen", entity.getUserName());
      assertEquals("passWord: ", "1314520", entity.getUserPwd());
    }


}

