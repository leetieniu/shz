package com.angel.shz.web.filter;

import com.angel.common.util.Constants;
import com.angel.common.util.sessionutil.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lijn on 2015/6/10.
 *
 */
public class LoginFilter implements Filter {

    private static final String FILTER_PATH = "filterPath";  //需要过滤掉的路径集合已#分隔

    private String[] allowUrls; //允许的路径

    /**
     * @param filterConfig filterConfig
     * 初始化filter,初始化过滤路径
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterPath = filterConfig.getInitParameter(FILTER_PATH);
        if ( filterPath != null && !"".equals(filterPath) ) {
            allowUrls = filterPath.contains("#") ? filterPath.split("#") : new String[]{filterPath};
        }
    }

    /**
     * 过滤请求,对不同请求分别处理 1属于授权url——继续，2已登录——继续，3其他——阻止（从定向）
     * @param request request
     * @param response response
     * @param chain chain
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        //1.用正则表达式验证授权url
        String servletPath = servletRequest.getServletPath();
        if (null != allowUrls && allowUrls.length > 0) {
            for (String urlRegex : allowUrls) {
                Pattern p=Pattern.compile(urlRegex);
                Matcher matcher=p.matcher(servletPath);
                if (matcher.find()) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }

        //2已登录
        if(SessionUtil.containsMessage(servletRequest, Constants.SESSION_KEY_USER)){
                chain.doFilter(request,response);
                return;
        }

        //3从定向到登录页
        backlogin(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    /** 如果 是ajax则返回响应，如果是正常web请求则重定向
     * @param servletRequest servletRequest
     * @param servletResponse servletResponse
     *
     * @throws IOException
     */
    private void backlogin(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        URI uri = URI.create(servletRequest.getRequestURL().toString());
        String loginUrl = "http://"+uri.getHost()+":"+servletRequest.getServerPort();
        if (servletRequest.getHeader("X-Requested-With") != null &&
                servletRequest.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            servletResponse.setHeader("Session-Status", "Session-Out");   //在响应头设置session状态

            servletResponse.setHeader("Redirect-Url", loginUrl);//在响应头设置跳转URL
            servletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.println("{\"code\":302,\"data\":{\"url\": \"" + loginUrl + "\"}}");
        } else {
            servletResponse.setContentType("text/html"); //如果为空,则进行未登录处理
            servletResponse.sendRedirect(loginUrl); // 未登录跳转到登录页面
        }
    }


}
