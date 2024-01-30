package com.about.allinone.controller;

import com.about.allinone.request.CheckIdRequest;
import com.about.allinone.request.JoinRequest;
import com.about.allinone.response.JoinResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllInOneService {

  /**
   * 중복인 id : me1234
   * */
  public boolean checkId(@Valid CheckIdRequest request) {
    //해당 부분은 flag로 처리하겨도 좋고 exception으로 진행하셔도 좋습니다
    return !request.getId().equalsIgnoreCase("me1234");
  }

  /**
   * id : me1234
   * pass : 1234
   * */
  public String findPassword(String id) {
    if (id.equalsIgnoreCase("me1234")) {
      return "1234";
    } else {
      return "fail";
    }
  }

  public JoinResponse join(JoinRequest request) {
    log.info("validation 통과 = {}", request);
    JoinResponse response = new JoinResponse(true, request.getId(), request.getPassword());

    log.info("response = {}", response);
    return response;
  }
}
