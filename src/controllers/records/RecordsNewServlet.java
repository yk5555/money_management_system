package controllers.records;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Record;

/**
 * Servlet implementation class recordsNewServlet
 */
@WebServlet("/records/new")
public class RecordsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        Record r = new Record();
        r.setRecord_date(new Date(System.currentTimeMillis()));
        request.setAttribute("record", r);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/records/new.jsp");
        rd.forward(request, response);
    }

}