package demo.web.controller.routers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.model.User;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRouter {

    @Autowired
    ObjectMapper objectMapper;

    private static final String USER_PATH = "/api/user/:userId";

    public Router getUser(Vertx vertx) {
        Router router = Router.router(vertx);
        router.route(USER_PATH).handler(routingContext -> {
            //TODO validate params
            Integer userId = Integer.valueOf(routingContext.request().getParam("userId"));
            //TODO search user in database
            User user = new User(userId, "user1", "develociraptor");

            HttpServerResponse response = routingContext.response();
            response.putHeader("Content-Type", "application/json");
            try{
                response.end(this.objectMapper.writeValueAsString(user));
            }
            catch (JsonProcessingException e) {
                routingContext.fail(e);
            }

        });
        return router;
    }
}
