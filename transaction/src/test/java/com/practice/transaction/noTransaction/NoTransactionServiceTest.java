package com.practice.transaction.noTransaction;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.BeforeEach;
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

  @Mapper
  private TransactionMapper mapper;


  /** 모든 테스트 전에 공통적으로 이루어져야 하는 것들 적는 곳 */
  @BeforeEach
  void before(){
    Account sender = service.getAccountById(SENDER_ID);
    Account receiver = service.getAccountById(RECEIVER_ID);
    sender.setBalance(10000L);
    receiver.setBalance(0L);
    mapper.updateAccountBalance(sender);
    mapper.updateAccountBalance(receiver);
  }
  /** 모든 테스트 전에 공통적으로 이루어져야 하는 것들 적는 곳 */

  @Test
  @DisplayName("이체 테스트 001 : 정상 이체")
  void testTransfer_001(){
    Transfer transfer = service.transfer(SENDER_ID,RECEIVER_ID,AMOUNT);
    // 10000원 가진 친구가 5000원을 이체 했을때
    assertEquals(5000L,transfer.getSender().getBalance());
    assertEquals(5000L,transfer.getReceiver().getBalance());
  }

  /** 의도적인 에러 발생 */
  void testTransfer_002(){
    Exception e = assertThrows(Exception.class , () -> {
      service.transfer(SENDER_ID, 901L, AMOUNT);
    });

    assertEquals(e.getClass().getSimpleName(),"BadSqlGrammerException");

  }

}