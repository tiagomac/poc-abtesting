package br.com.valemobi.poc.abtestingbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/cookie")
class CookieController {
    
    @GetMapping
    fun setCookie(response: HttpServletResponse): String {
        val cookie: Cookie = Cookie("canary", "always");
        response.addCookie(cookie);     
        return "\"canary\" cookie set successfully";
    }

}