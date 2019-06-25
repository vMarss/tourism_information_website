package cn.wolfcode.trip.app.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptortor implements HandlerInterceptor {
    //配置拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object currentUser = request.getSession().getAttribute("USER_IN_SESSION");
//        System.out.println("当前存在session的对象为 ： " + currentUser);
        //不能从Session中取到user对象，说明还没有存
        if (currentUser == null) {
            //未登录就跳转到登录界面
            response.sendRedirect("/login.html");
            return false;
        }
        //已经登录了就放行
        return true;
    }
}
