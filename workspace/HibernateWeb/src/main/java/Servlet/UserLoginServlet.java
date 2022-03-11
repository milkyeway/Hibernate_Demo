package Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import service.MemberLoginService;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserLoginServlet() {
        super();
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		
		HttpSession httpsession = request.getSession();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		MemberLoginService mService = new MemberLoginService();
		
		Member tempMember = mService.checkLogin(username, password);
		
		if(tempMember != null) {
			httpsession.setAttribute("loginOK", tempMember.getMemberName());
		} else {
			errorMsgMap.put("LoginError", "帳號密碼錯誤，請重新輸入");
		}
		
		if(errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("loginOK.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}


}
