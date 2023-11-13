package com.picpaysimplificado.services;

import com.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.model.transaction.Transaction;
import com.picpaysimplificado.model.user.User;
import com.picpaysimplificado.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Service
public class TransactionService {

    public static final String URL_CHECK   = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transactionDTO) throws Exception {
        User sender = this.userService.findUserById(transactionDTO.senderId());
        User receiver = this.userService.findUserById(transactionDTO.receiverId());

        userService.ValidUserTransaction(sender, transactionDTO.amount());

        if (!this.authorizeTransaction(sender, transactionDTO.amount())){
            throw new Exception("Transaction not authorized");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transactionDTO.amount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);

        sender.setBalance(sender.getBalance().subtract(transactionDTO.amount()));
        receiver.setBalance(receiver.getBalance().add(transactionDTO.amount()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }

    public boolean authorizeTransaction(User sender, BigDecimal amount){
       ResponseEntity<Map> authResponse = restTemplate.getForEntity(URL_CHECK, Map.class);

        if (authResponse.getStatusCode() == HttpStatus.OK){
            String message = (String) Objects.requireNonNull(authResponse.getBody()).get("messsage");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }
}
