package main.java.com.aloha.springnote.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.springnote.dto.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    
    /**
     *  // [Post] - /test
        // data : (BODY) > (JSON) > { "data1" : "value1", "data2", "value2" }
     * @param map
     * @return
     *  ⭐ @ReauestBody
     *     : HTTP 요청 메세지의 본문(BODY) 를 메소드의 파라미터로 매핑하는 어노테이션
     *   ✅ 주로 JSON, XML 데이터를 파라미터로 매핑하는 데 사용
     *      body : formData
     *      - POST 로 요청 시 , formData 도 body 에 담겨져서 보내진다.
     *  (Spring) 
     *   - 폼으로 전송된 요청 body에 데이터가 있지만,
     *     스프링이 데이터를 처리하기 위해,
     *     내부적으로 body에 있는 데이터를 요청 파라미터에 매핑합니다.
     *   -> 그래서, 폼 요청 데이터는 @RequestParam 으로 매핑 가능합니다.    
     */
    
    @PostMapping("/json")
    public String jsonTest(@RequestBody Map<String,String> map) {
        log.info("[GET] - /test");
        log.info("map : " + map);
        Set<String> set = map.keySet();
        for( String key : set ) {
            String value = map.get(key);
            log.info("key : " + key + ", value : " + value);
        }
        return "test";
    }

    @PostMapping("/form")
    public String formTest(Map<String,String> map) {
        log.info("[GET] - /test");
        log.info("map : " + map);
        Set<String> set = map.keySet();
        for( String key : set ) {
            String value = map.get(key);
            log.info("key : " + key + ", value : " + value);
        }
        return "test";
    }

    /**
     * /test/form/user
     * @RequestParam
     * @param user
     * @return
     */
    @PostMapping("/form/user")
    public String user(User user) {
        log.info("[POST] - /test/user");
        log.info("user : " + user);
        return "test";
    }
    
    /**
     * /test/json/user
     * @RequestBody
     * - 요청 본문의 데이터를 객체로 매핑한다.
     * json 으로 받아올 때 @RequestBody 생략하면 내가만든 객체라도 자동매핑 안됨 
     * (form 형식만 스프링에서 자동매핑해줌)
     * @param user
     * @return
     */
    @PostMapping("/json/user")
    public String jsonuser(User user) {
        log.info("[POST] - /test/user");
        log.info("user : " + user);
        return "test";
    }
    
    /**
     * @ModelAttribute
     * 컨트롤러 메소드의 파라미터를 자동으로 모덜에 등록해주는 어노테이션
     * name 을 지정하지 않으면, 변수명을 name으로 지정한다.
     * @param user
     * @return
     */
    @GetMapping("/model")
    public String testModel(@ModelAttribute User user) {
        user.setId("김조은");
        user.setPw("123");
        return "user";
    }

    /**
     * @ReponseBody
     * : 응답 메세지 본문에 데이터를 담아서 전송해주는 어노테이션
     * 뷰 페이지를 응답하지않고, 텍스트 데이터를 그대로 응답한다.
     * @return
     */
    @ResponseBody
    @GetMapping("/body")
    public String testBody() {
        return "TEST";
    }
    
    

}
