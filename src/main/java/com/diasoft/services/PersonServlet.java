package com.diasoft.services;

import com.diasoft.entities.Contact;
import com.diasoft.entities.ContactType;
import com.diasoft.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet
public class PersonServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    private XMLTransformer transformer = XMLTransformer.getInstance();

    public PersonServlet() {
    }

    //findAll
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Person> persons = personService.findAll();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/xml; charset=UTF-8");
        out.write(transformer.toXMLString(persons));
        out.flush();
    }

    //add
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        personService.saveOrUpdate(req);

        this.doGet(req, resp);
    }

    //Update
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        personService.update(req);
        this.doGet(req, resp);
    }

    //Delete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        personService.deleteById(Long.valueOf(req.getParameter("id")));
        this.doGet(req, resp);
    }
}
