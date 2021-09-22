package br.com.valemobi.poc.abtestingbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/hello")
class HelloController {
    
    @GetMapping
    fun hello(request: HttpServletRequest): String {
        val cookies = request.cookies ?: emptyArray<Cookie>()
        val canaryCookie = cookies.firstOrNull {
                cookie -> cookie.name.equals("canary") 
        };
        val strReturn = """
            hello from v2 : ${LocalDateTime.now()} <br> 
            canary for a/b testing: <span style="color:red"><strong>${canaryCookie?.value ?: "not found"}</strong></span>
        """.trimIndent()
        return strReturn;
    }
}