package demo.web.controller.server;

import demo.web.controller.routers.UserRouter;
import io.vertx.core.Future;
import io.vertx.core.AbstractVerticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class HttpServerVerticle extends AbstractVerticle {

    @Autowired
    UserRouter userRouter;

    @Override
    public void start(Future<Void> fut) {
        vertx.createHttpServer().requestHandler(userRouter.getUser(vertx)).listen(8080);
    }




}
