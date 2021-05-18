package cn.woodwhales.rbac.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woodwhales on 2021-05-18 14:58
 * @description
 */
@Slf4j
@RestController
public class AliveController {

    @GetMapping("/alive")
    public String alive() {
        log.info("alive is ok");
        return "ok";
    }

}
