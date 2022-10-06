package aaj.springreactiveexample.handler;

import aaj.springreactiveexample.component.TestWaitAsyncComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WaitHandlerImpl implements WaitHandler {
  private final TestWaitAsyncComponent testWaitAsyncComponent;

  @Autowired
  public WaitHandlerImpl(TestWaitAsyncComponent testWaitAsyncComponent) {
    this.testWaitAsyncComponent = testWaitAsyncComponent;
  }

  @Override
  public Mono<ServerResponse> getWait(ServerRequest request) {
    testWaitAsyncComponent.doWait();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("{\"status:\" \"ok\"}");
  }
}
