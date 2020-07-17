package com.diasoft.services;

import com.diasoft.entities.Person;
import lombok.NoArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet
public class PersonServlet  extends HttpServlet {

    private PersonService personService = new PersonService();

    public PersonServlet() {
    }



    //findAll
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("hello");
//        List<Person> persons = personService.findAll();
//        PrintWriter out = resp.getWriter();
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        out.write("<H1>hello<H1>");
////        out.print(persons.get(0));
//        out.flush();
    }


    //add
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        person.setFirst_name(req.getParameter("firstName"));
        person.setLast_name(req.getParameter("lastName"));
        person.setMiddle_name(req.getParameter("middleName"));
        person.setPosition(req.getParameter("position"));

        String number = req.getParameter("number");
        String type = req.getParameter("type");


        this.doGet(req, resp);
    }

    //update
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    //Delete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        personService.deleteById(Long.valueOf(req.getParameter("id")));
        this.doGet(req, resp);
    }
}
