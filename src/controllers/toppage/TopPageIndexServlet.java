package controllers.toppage;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/money")
public class TopPageIndexServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopPageIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Person login_person = (Person)request.getSession().getAttribute("login_person");

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        List<Record> records = em.createNamedQuery("getMyAllRecords", Record.class)
                                  .setParameter("person", login_person)
                                  .setFirstResult(3 * (page - 1))
                                  .setMaxResults(3)
                                  .getResultList();

        long records_count = (long)em.createNamedQuery("getMyRecordsCount", Long.class)
                                     .setParameter("person", login_person)
                                     .getSingleResult();

        long records_money;
        try{
              records_money = em.createNamedQuery("getRecordsMoney", Long.class)
                .setParameter("person", login_person)
                .getSingleResult();
        }catch (NullPointerException e){
              records_money = 0;
        }

        em.close();

        request.setAttribute("records_money", records_money);
        request.setAttribute("records", records);
        request.setAttribute("records_count", records_count);
        request.setAttribute("page", page);

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/toppage/money.jsp");
        rd.forward(request, response);
    }

}