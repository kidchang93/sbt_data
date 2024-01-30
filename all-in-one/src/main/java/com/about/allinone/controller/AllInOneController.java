package com.about.allinone.controller;

import com.about.allinone.request.CheckIdRequest;
import com.about.allinone.request.JoinRequest;
import com.about.allinone.response.JoinResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/all")
@RequiredArgsConstructor
public class AllInOneController {

  private final AllInOneService service;

  @GetMapping("")
  public String getView() {
    return "allInOne";
  }

  /**
   * Vaildation Error : MethodArgumentNotValidException.class
   * */

  @GetMapping("/check/id")
  @ResponseBody
  public boolean checkId(@ModelAttribute @Valid CheckIdRequest request, Model model) {
    return service.checkId(request);
  }

  /**
   * No Validation > Success > jsp에서 분기 처리
   * */
  @GetMapping("/find/pass")
  @ResponseBody
  public Map<String, Object> findPassword(@RequestParam(name = "id") String id, Model model) {
    String result = service.findPassword(id);
    Map<String, Object> map = new HashMap<>();
    if (result.equalsIgnoreCase("fail")) {
      map.put("result", result);
    } else map.put("result", result);
    return map;
  }

  /**
   * Vaildation Error, 통과시 return join response;
   * */
  @PostMapping("/join")
  @ResponseBody
  public JoinResponse join(@RequestBody @Valid JoinRequest request, Model model) {
    return service.join(request);
  }

}
