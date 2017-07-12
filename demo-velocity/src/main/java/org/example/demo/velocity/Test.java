package org.example.demo.velocity;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Test {
    public static void main(String[] args) throws Exception {
        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");
        context.put("project", "Jakarta");
        StringWriter w = new StringWriter();

        String s = "We are using $project $name to render this.";
        w = new StringWriter();
        Velocity.evaluate(context, w, "mystring", s);
        // We are using Jakarta Velocity to render this.
        System.out.println(w);
    }
}
