package com.interceptor;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

public class FileTypeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception {
        boolean flag= true;
        // 判断是否为文件上传请求
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest =
                    (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files =
                    multipartRequest.getFileMap();
            Iterator<String> iterator = files.keySet().iterator();
            //对多部件请求资源进行遍历
            while (iterator.hasNext()) {
                String formKey = (String) iterator.next();
                MultipartFile multipartFile =
                        multipartRequest.getFile(formKey);
                String filename=multipartFile.getOriginalFilename();
                //判断是否为限制文件类型
                if (! checkFile(filename)) {
                    //限制文件类型，请求转发到原始请求页面，并携带错误提示信息
                    //request.setAttribute("errormessage", "不支持的文件类型！");
                    //request.getRequestDispatcher("/WEB-INF/jsp/userEdit.jsp")
                            //.forward(request, response);
                    System.out.println("不支持的文件类型！");
                    //response.setContentType("text/html; charset=UTF8");
                    //response.setCharacterEncoding("UTF8");
                    response.getWriter().print("不支持的文件类型！");
                    flag= false;
                }
            }
        }
        return flag;
    }
    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    private boolean checkFile(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".")
                + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }
}
