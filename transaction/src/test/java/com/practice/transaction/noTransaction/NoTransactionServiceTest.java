package com.practice.transaction.noTransaction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoTransactionServiceTest {

  private Long SENDER_ID = 1L;
  private Long RECEIVER_ID = 2L;
  private Long AMOUNT = 5000L;

  @Autowired
  private NoTransactionService service;

  @Test
  @DisplayName("이체 테스트 001 : 정상 이체")
  void testTransfer_001(){
    service.transfer(SENDER_ID,RECEIVER_ID,AMOUNT);
  }

}