/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.web.mvc.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.hoteia.qalingo.core.domain.enumtype.FoUrls;
import org.hoteia.qalingo.core.web.resolver.RequestData;
import org.hoteia.qalingo.core.web.servlet.ModelAndViewThemeDevice;
import org.hoteia.qalingo.core.web.servlet.view.RedirectView;
import org.hoteia.qalingo.web.mvc.controller.AbstractMCommerceController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 */
@Controller("homeController")
public class HomeController extends AbstractMCommerceController {

	@RequestMapping(FoUrls.HOME_URL)
	public ModelAndView displayHome(final HttpServletRequest request, final Model model) throws Exception {
	    ModelAndViewThemeDevice modelAndView = new ModelAndViewThemeDevice(getCurrentVelocityPath(request), FoUrls.HOME.getVelocityPage());

        overrideDefaultPageTitle(request, modelAndView, FoUrls.HOME.getKey());

        return modelAndView;
	}
	
	@RequestMapping(FoUrls.INDEX_URL)
	public ModelAndView displayIndex(final HttpServletRequest request, final Model model) throws Exception {
        return displayHome(request, model);
	}
	
    @RequestMapping("/")
    public ModelAndView displayDefaultPage(final HttpServletRequest request, final Model model) throws Exception {
        final RequestData requestData = requestUtil.getRequestData(request);
        
        // DEFAULT HOME
        String defaultUrl = urlService.generateRedirectUrl(FoUrls.HOME, requestData);
        
        // TODO: GEOLOC AND CHOOSE THE GOOD MARKET
        
        return new ModelAndView(new RedirectView(defaultUrl));
    }
    
}