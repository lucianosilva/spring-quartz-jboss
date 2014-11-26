/**
 *  Licenca Creative Commons
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.blog.control.impl;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.lucianosilva.blog.control.ExecuteTaskControl;

/**
 * 
 *
 * @autor luciano
 * @version $Rev$ $Date$
 */
@Controller
public class ExecuteTaskControlImpl implements ExecuteTaskControl {

	/* (non-Javadoc)
	 * @see com.lucianosilva.blog.control.ExecuteTaskControl#execute()
	 */
	@Override
	public void execute() throws Exception {
		// 
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }//

	}

}
