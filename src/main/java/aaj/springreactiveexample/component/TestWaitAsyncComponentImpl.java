package aaj.springreactiveexample.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Async
@Component
@Log4j2
public class TestWaitAsyncComponentImpl implements TestWaitAsyncComponent {
  @Override
  public void doWait() {
    try {
      System.out.println("Inicio de sleep 0s");
      TimeUnit.SECONDS.sleep(10);
      System.out.println("Final de sleep 10s");
    } catch (Exception e) {
      log.error("Error schedule", e);
    }
  }
}
