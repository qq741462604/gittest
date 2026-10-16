package com.cmbchina.plugin.extension;

import com.cmbchina.rces.executor.common.ContextKeyConstant;
import com.cmbchina.rces.executor.common.EventData;
import com.cmbchina.rces.executor.exception.EventHandlerException;
import com.cmbchina.rces.executor.pipeline.AbstractPipeline;
import com.cmbchina.rces.executor.pipeline.PipelineContext;
import com.cmbchina.rces.executor.rceseventhandler.RcesEventHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 自定义的handler在框架的pipeline体系里面，所以不需要配合注解使用
 *
 * @author 西安真的好热
 * @date 2025/8/12 10:36
 */
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

            //初始化ip、lbs翻译相关字段
            // eventFields.put(LBS_CITY, "");
            // eventFields.put(LBS_COUNTRY, "");
            // eventFields.put(IP_CITY, "");
            // eventFields.put(IP_COUNTRY, "");
            // eventFields.put("test", "abcd");



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
