package cn.wolfcode.trip.app.web.filter;

import cn.wolfcode.trip.app.util.UploadUtil;
import org.apache.commons.io.FileUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ImageFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取过滤器得到的URI
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        //System.out.println(requestURI);

        //将得到的路径拼成完整的路径
        String filePath = UploadUtil.commonPath + requestURI;
        File f = new File(filePath);
        //文件存在，将文件转为二进制字节码返回到response中
        if (f.exists()) {
            servletResponse.getOutputStream().write(FileUtils.readFileToByteArray(f));
        } else {
            //放行，执行过滤器链的下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
