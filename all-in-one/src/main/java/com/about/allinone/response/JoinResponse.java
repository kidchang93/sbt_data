package com.about.allinone.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinResponse {
  private boolean flag;
  private String id;
  private String password;


  public String getPassword() {
    return createAstricPassword(password);
  }

  private String createAstricPassword(String password) {
    String astricPassword = "";
    StringBuilder builder = new StringBuilder();
    builder.append(password, 0, 3);
    for (int i = 0; i < password.length() - 3; i++) {
      builder.append("*");
    }
    astricPassword = builder.toString();

    return astricPassword;
  }
}
