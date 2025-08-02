package org.apache.dubbo.samples.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.protocol.tri.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;

@Slf4j
@Component
public class ProviderRunner implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 2).forEach(number -> {
            restTemplate.getForObject("http://localhost:50051/query1?id=" + number, Void.class);
            LOGGER.info("==========query1 OK==========,id=" + number);
            try {
                restTemplate.getForObject("http://localhost:50051/query1?id=0", Void.class);
            } catch (Exception e) {
                LOGGER.error("==========query1 ERROR==========,id=0", e);
                Throwable unwrap = ExceptionUtils.unwrap(e);
                LOGGER.error("==========query1 ERROR==========,id=0", unwrap);
                // Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                // violations.forEach(v -> {
                //     LOGGER.error(v.getPropertyPath() + v.getMessage());
                // });
            }
        });
    }

}
