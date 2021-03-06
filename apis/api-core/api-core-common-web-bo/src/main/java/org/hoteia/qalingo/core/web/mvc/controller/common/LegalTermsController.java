/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.web.mvc.controller.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hoteia.qalingo.core.ModelConstants;
import org.hoteia.qalingo.core.domain.enumtype.BoUrls;
import org.hoteia.qalingo.core.i18n.enumtype.ScopeWebMessage;
import org.hoteia.qalingo.core.web.mvc.controller.AbstractBackofficeQalingoController;
import org.hoteia.qalingo.core.web.mvc.viewbean.SeoDataViewBean;
import org.hoteia.qalingo.core.web.resolver.RequestData;
import org.hoteia.qalingo.core.web.servlet.ModelAndViewThemeDevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 */
@Controller("legalTermsController")
public class LegalTermsController extends AbstractBackofficeQalingoController {

	@RequestMapping(BoUrls.LEGAL_TERMS_URL)
	public ModelAndView legalTerms(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return new ModelAndViewThemeDevice(getCurrentVelocityPath(request), BoUrls.LEGAL_TERMS.getVelocityPage());
	}

    @ModelAttribute(ModelConstants.SEO_DATA_VIEW_BEAN)
    protected SeoDataViewBean initSeo(final HttpServletRequest request, final Model model) throws Exception {
        final RequestData requestData = requestUtil.getRequestData(request);
        SeoDataViewBean seoDataViewBean = backofficeViewBeanFactory.buildViewSeoData(requestData);
        final Locale locale = requestData.getLocale();
        final String pageKey = BoUrls.LEGAL_TERMS_KEY;
        final String pageTitle = getSpecificMessage(ScopeWebMessage.SEO, getMessageTitleKey(pageKey), locale);
        seoDataViewBean.setPageTitle(pageTitle);
        return seoDataViewBean;
    }
}