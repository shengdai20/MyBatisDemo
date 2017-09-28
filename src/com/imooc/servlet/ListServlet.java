package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.QueryService;

/*
 * 列表页面初始化控制
 */
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码，一般用过滤器来做
		req.setCharacterEncoding("UTF-8");
		//接受页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		//向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//查询消息列表并传给页面
		QueryService queryService = new QueryService();
		req.setAttribute("messageList", queryService.queryMessageList(command, description));
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
