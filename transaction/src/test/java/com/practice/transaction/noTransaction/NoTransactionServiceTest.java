package com.practice.transaction.noTransaction;

import com.practice.transaction.Transfer;
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
    Transfer transfer = service.transfer(SENDER_ID,RECEIVER_ID,AMOUNT);
    // 10000원 가진 친구가 5000원을 이체 했을때
    assertEquals(5000L,transfer.getSender().getBalance());
    assertEquals(5000L,transfer.getReceiver().getBalance());
  }

}