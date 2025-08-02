package org.apache.dubbo.samples.validation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.samples.validation.api.model.DeleteParameter;
import org.apache.dubbo.samples.validation.api.model.QueryParameter;
import org.apache.dubbo.samples.validation.api.model.SaveOrUpdateParameter;
import org.apache.dubbo.samples.validation.api.ValidationRestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class ValidationRestServiceImpl implements ValidationRestService {

    @Override
    public void query1(Integer id) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.query1", id);
    }

    @Override
    public void query2(QueryParameter parameter) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.query2", parameter);
    }

    @Override
    public void query3(QueryParameter parameter) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.query3", parameter);
    }

    @Override
    public void save(SaveOrUpdateParameter parameter) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.save", parameter);
    }

    @Override
    public void update(SaveOrUpdateParameter parameter) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.update", parameter);
    }

    @Override
    public void delete(DeleteParameter parameter) {
        LOGGER.info("==========[{}][{}]==========", "ValidationRestService.delete", parameter);
    }

}
