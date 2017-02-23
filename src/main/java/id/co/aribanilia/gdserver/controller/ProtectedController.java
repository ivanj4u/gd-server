package id.co.aribanilia.gdserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@Controller
public class ProtectedController {

    @GetMapping("/protected")
    public void protectedPage() {
    }
}
