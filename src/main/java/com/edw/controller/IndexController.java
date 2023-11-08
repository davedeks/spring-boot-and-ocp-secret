package com.edw.controller;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 13 Agt 2021 09:29
 */
@Component
public class IndexController extends RouteBuilder {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure() {        
        from("timer:myTimer?repeatCount=1")
        .setBody(simple("SELECT empName, empEmail FROM LEARN101.dbo.employees"))
        .log("SQL: ${body}")
        .log("Out: {OPENSHIFT_APP_PASSWORD}");

    // @Value("${server.password}")
    // private String serverPassword;

    // @GetMapping("/")
    // public Map helloWorld() {
    //     return new HashMap() {{
    //         put("hello", "world");
    //         put("password", serverPassword);
    //     }};
    // }
    }
}
