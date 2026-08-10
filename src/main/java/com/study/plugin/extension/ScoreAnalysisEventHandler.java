package com.study.plugin.extension;

import com.cmbchina.plugin.service.StrategyService;
import com.cmbchina.plugin.utils.SpringContextBeanUtil;
import com.cmbchina.rces.executor.common.ContextKeyConstant;
import com.cmbchina.rces.executor.common.EventData;
import com.cmbchina.rces.executor.common.RTDecisionResult;
import com.cmbchina.rces.executor.exception.EventHandlerException;
import com.cmbchina.rces.executor.pipeline.AbstractPipeline;
import com.cmbchina.rces.executor.pipeline.PipelineContext;
import com.cmbchina.rces.executor.rceseventhandler.RcesEventHandler;
import com.cmbchina.plugin.utils.ResourceUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author 西安真的好热
 * @date 2025/8/12 10:53
 */
@Slf4j
public class ScoreAnalysisEventHandler extends RcesEventHandler {

    public static StrategyService strategyService = SpringContextBeanUtil.getApplicationContext().getBean(StrategyService.class);

    /**
     * 会在executor-core的pipeline初始化的时候调用
     *
     * @param pipeline
     */
    @Override
    public void init(final AbstractPipeline pipeline) {
        super.init(pipeline);
        log.info("CustomerEventHandler(自定义) init.");
        //增加自己的逻辑，比如获取一些配置信息，初始化一些对象等
        log.info("CustomerEventHandler(自定义) end.");
    }

    /****************************************************/

    @Override
    public void handle(final PipelineContext context) throws EventHandlerException {
        long t = System.currentTimeMillis();
        EventData eventData = (EventData)context.getUserData().get(ContextKeyConstant.EVENT_DATA);
        //整个过程中需要使用EventData中的信息，可以参照EventData的定义
        // //事件变量
        // Map<String, Object> eventFields = eventData.getEventVars();
        // //实时变量
        // Map<String, Object> rtqVars = eventData.getRtqVars();
        // //聚合变量
        // Map<String, Object> procVars = eventData.getProcVars();
        // //外部变量
        // Map<String, Object> externalVars = eventData.getExternalVars();

        //获取rtd决策计算结果
        Map<String, Object> rtdResults = eventData.getRtdResults();
        //流水号
        String seqNo = eventData.getSeqNo();

        try {
            // 决策得分
            int droolsScore = rtdResults.get("score") == null ? 0 : Integer.parseInt(rtdResults.get("score").toString());
            int decision = strategyService.match(droolsScore);
            rtdResults.put("scoreResult", decision);
        } catch (Exception e) {
            log.error("报错啦: {}", e.getMessage());
        }

        log.info("seqNo: {}", seqNo);
        log.info("CustomerEventHandler start...");
        /**
         * 更新最终决策结果，必不可少
         */
        context.getUserData().put(ContextKeyConstant.RT_DECISION_RESULT, RTDecisionResult.fromEventDataSimple(eventData));
        long t1 = System.currentTimeMillis();
        log.info("CustomerEventHandler cost {} ms,seqNo:{}", t1 - t, seqNo);
    }


}