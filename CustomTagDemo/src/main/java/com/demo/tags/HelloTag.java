package com.demo.tags;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

    private String name; // Attribute

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (name == null || name.isEmpty()) {
            out.println("<h2>Hello, Guest!</h2>");
        } else {
            out.println("<h2>Hello, " + name + "!</h2>");
        }
    }
}
