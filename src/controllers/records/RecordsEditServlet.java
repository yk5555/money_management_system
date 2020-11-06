package controllers.records;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import models.Record;
import utils.DBUtil;

/**
 * Servlet implementation class recordsEditServlet
 */
@WebServlet("/records/edit")
public class RecordsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Record r = em.find(Record.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        Person login_person = (Person)request.getSession().getAttribute("login_person");
        if(r != null && login_person.getId() == r.getPerson().getId()) {
            request.setAttribute("record", r);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("record_id", r.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/records/edit.jsp");
        rd.forward(request, response);
    }

}