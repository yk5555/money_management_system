package controllers.persons;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utils.DBUtil;

/**
 * Servlet implementation class personsShowServlet
 */
@WebServlet("/persons/show")
public class PersonsShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Person e = em.find(Person.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("person", e);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/persons/show.jsp");
        rd.forward(request, response);
    }

}