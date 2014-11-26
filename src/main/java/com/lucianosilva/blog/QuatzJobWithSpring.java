/**
 *  Licenca Creative Commons
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.blog;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

import com.lucianosilva.blog.control.ExecuteTaskControl;


/** 
 * @author luciano
 *
 */
public class QuatzJobWithSpring implements Job {
	//
	private static final Logger logger = Logger.getLogger(QuatzJobWithSpring.class);

	private ApplicationContext applicationContext;
	private ExecuteTaskControl executeTaskControl;

	@Override
	public void execute( JobExecutionContext context ) throws JobExecutionException {
		logger.info("*************** [ Job execution has started ] *************** ");
		
		try {
			//
			SchedulerContext schedulerContext = context.getScheduler().getContext();
			logger.debug("Scheduler Context : " + schedulerContext);
			//
			applicationContext = (ApplicationContext) schedulerContext.get("applicationContext");

		} catch (SchedulerException e1) {
			logger.error("Erro ao tentar localizar ApplicationContext. " + e1.getMessage(), e1);
		}

		// 
		logger.debug("Application Context : " + applicationContext);
		if( applicationContext!=null ){
			executeTaskControl = (ExecuteTaskControl) applicationContext.getBean("executeTaskControlImpl");
		}

		logger.debug("chamou o executeTaskControl.execute()... ");
		try {
			executeTaskControl.execute();
		} catch (Exception e) {
			logger.error(e);
		}
		
		logger.info("*************** [ Job execution has finished ] *************** ");
		
	}

}
