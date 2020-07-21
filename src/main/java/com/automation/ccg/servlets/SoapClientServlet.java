package com.automation.ccg.servlets;

import com.ccgautomation.eval.EvalClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SoapClientServlet extends HttpServlet {

    private final String PARAMETER_REFERENCE_NAME = "referenceName";
    private final String PARAMETER_VALUE = "value";
    private final String PARAMETER_USERNAME = "username";
    private final String PARAMETER_PASSWORD = "password";
    private RequestDispatcher homeJsp;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/soap.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String referenceName = req.getParameter(PARAMETER_REFERENCE_NAME);
        String value = req.getParameter(PARAMETER_VALUE);
        String username = req.getParameter(PARAMETER_USERNAME);
        String password = req.getParameter(PARAMETER_PASSWORD);

        if ((referenceName == null) || (username == null) || (password == null)){
            req.setAttribute("message", "Enter Data Above");
            req.setAttribute(PARAMETER_REFERENCE_NAME, "/trees/config/system/auditlogging/auditlogfile/logfilename.value");
            homeJsp.forward(req, resp);
        }

        req.setAttribute(PARAMETER_REFERENCE_NAME, referenceName);
        req.setAttribute(PARAMETER_VALUE, value);
        req.setAttribute(PARAMETER_USERNAME, username);
        req.setAttribute(PARAMETER_PASSWORD, password);

        StringBuilder sb = new StringBuilder();
        sb.append(referenceName);
        sb.append("\r\n");
        sb.append(getValue(referenceName,username,password));

        req.setAttribute("message", sb.toString());
        homeJsp.forward(req, resp);
    }

    private String getValue(String referenceName, String username, String password) {
        String result = "";
        EvalClient evalClient = new EvalClient();

        result = evalClient.getValue(referenceName, username, password);

        return result;
    }

}
