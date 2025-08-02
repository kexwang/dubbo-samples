package org.apache.dubbo.samples.validation;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.samples.validation.api.model.SaveOrUpdateParameter;
import org.apache.dubbo.samples.validation.api.model.DeleteParameter;
import org.apache.dubbo.samples.validation.api.ValidationService;

import java.util.Date;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerRunner implements ApplicationRunner {

    @DubboReference
    private ValidationService validationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Save OK
        SaveOrUpdateParameter parameter = new SaveOrUpdateParameter();
        parameter.setName("yang siming");
        parameter.setEmail("1608839567@qq.com");
        parameter.setAge(50);
        parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
        parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
        validationService.save(parameter);
        LOGGER.info("Validation Save OK");

        // Save Error
        try {
            parameter = new SaveOrUpdateParameter();
            validationService.save(parameter);
        } catch (ConstraintViolationException e) {
            LOGGER.error("Validation Save ERROR");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            violations.forEach(v -> {
                LOGGER.error(v.getPropertyPath() + v.getMessage());
            });
        }

        // Delete OK
        DeleteParameter parameter2 = new DeleteParameter();
        parameter2.setId(2);
        parameter2.setOperator("abc");
        validationService.delete(parameter2);
        LOGGER.info("Validation Delete OK");

        // Delete Error
        try {
            parameter2 = new DeleteParameter();
            parameter2.setId(0);
            parameter2.setOperator("abc");
            validationService.delete(parameter2);
        } catch (ConstraintViolationException e) {
            LOGGER.error("Validation Delete ERROR");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            violations.forEach(v -> {
                LOGGER.error(v.getPropertyPath() + v.getMessage());
            });
        }

        // Update OK
        parameter = new SaveOrUpdateParameter();
        parameter.setName("yang siming");
        parameter.setAge(50);
        parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
        parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
        validationService.update(parameter);
        LOGGER.info("Validation Update OK");

        // Update Error
        try {
            parameter = new SaveOrUpdateParameter();
            validationService.update(parameter);
        } catch (ConstraintViolationException e) {
            LOGGER.error("Validation Update ERROR");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            violations.forEach(v -> {
                LOGGER.error(v.getPropertyPath() + v.getMessage());
            });
        }
    }

}
