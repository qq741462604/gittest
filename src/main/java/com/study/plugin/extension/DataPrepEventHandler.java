package com.study.plugin.extension;

import com.cmbchina.rces.executor.common.ContextKeyConstant;
import com.cmbchina.rces.executor.common.EventData;
import com.cmbchina.rces.executor.exception.EventHandlerException;
import com.cmbchina.rces.executor.pipeline.AbstractPipeline;
import com.cmbchina.rces.executor.pipeline.PipelineContext;
import com.cmbchina.rces.executor.rceseventhandler.RcesEventHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class DataPrepEventHandler extends RcesEventHandler {

    // 待处理的事件域字段
    private static final String LBS_CITY = "lbsCity";
    private static final String LBS_COUNTRY = "lbsCountry";
    private static final String IP_CITY = "ipCity";
    private static final String IP_COUNTRY = "ipCountry";

    /**
     * 会在executor-core的pipeline初始化的时候调用
     *
     * @param pipeline
     */
    @Override
    public void init(final AbstractPipeline pipeline) {
        super.init(pipeline);
        log.info("DataPrepEventHandler(自定义) init.");
    }

    @Override
    public void handle(final PipelineContext context) throws EventHandlerException {
        if (log.isDebugEnabled()) {
            log.debug("DataPrepEventHandler handle begin.");
        }

        try {
            EventData eventData = (EventData)context.getUserData().get(ContextKeyConstant.EVENT_DATA);
            Map<String, Object> eventFields = eventData.getData();


            log.debug("DataPrepEventHandler eventFields: {}", eventFields);
        } catch (Exception ex) {
            log.error("DataPrepEventHandler preprocessing failed.", ex);
            throw new EventHandlerException("DataPrepEventHandler preprocessing failed.", ex);
        }

        if (log.isDebugEnabled()) {
            log.debug("DataPrepEventHandler end.");
        }
    }



}
