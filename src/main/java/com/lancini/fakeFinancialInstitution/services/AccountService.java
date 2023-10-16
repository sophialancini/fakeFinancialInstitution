package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Account;
import com.lancini.fakeFinancialInstitution.model.Customer;
import com.lancini.fakeFinancialInstitution.model.Transfer;
import com.lancini.fakeFinancialInstitution.repositories.AccountRepository;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransferHistoryService transferHistoryService;

    public Account createAccount(Long customerId, Long initialDeposit) throws Exception {
        Optional<Customer> customer = this.customerService.getCustomerById(customerId);
        if (customer.isPresent()) {
            return this.repository.save(new Account(customerId, customer.get(), initialDeposit));
        }
        else throw new Exception("Customer Id is invalid");
    }

    @Override
    public Long getAccountBalance(Long accountId) throws Exception {
        Optional<Account> account = this.repository.findById(accountId);
        if (account.isPresent()) return account.get().getBalance();
        else throw new Exception("Account is invalid");
    }

    @Override
    public List<Transfer> getTransferHistory(Long accountId) throws Exception {
        Optional<List<Transfer>> transfers = this.transferHistoryService.getByAccountId(accountId);
        if (transfers.isPresent()) return transfers.get();
        else throw new Exception("Account is invalid");
    }

    public Response.Status transferAmount(Transfer transfer) throws Exception {
        Optional<Account> senderOp = this.repository.findById(transfer.getSender().getId());
        Optional<Account> receiverOp = this.repository.findById(transfer.getReceiver().getId());
        if (senderOp.isEmpty() || receiverOp.isEmpty()) throw new Exception("Please verify account ids");

        Account sender = senderOp.get();
        Account receiver = receiverOp.get();

        Long amount = transfer.getAmount();

        if (sender.getBalance() < amount) {
            return Response.Status.BAD_REQUEST;
        }

        sender.setBalance(sender.getBalance()-amount);
        this.repository.save(sender);
        receiver.setBalance(receiver.getBalance()+amount);
        this.repository.save(receiver);

        return Response.Status.OK;
    }
}
