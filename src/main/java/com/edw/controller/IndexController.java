package com.edw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 13 Agt 2021 09:29
 */
@RestController
public class IndexController {

    @Value("${server.password}")
    private String serverPassword;

    @GetMapping("/")
    public Map helloWorld() {
        return new HashMap() {{
            put("hello", "world");
            put("password", serverPassword);
        }};
    }
}
