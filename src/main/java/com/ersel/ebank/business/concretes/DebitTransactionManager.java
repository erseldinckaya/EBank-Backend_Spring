package com.ersel.ebank.business.concretes;

import com.ersel.ebank.business.abstracts.DebitTransactionService;
import com.ersel.ebank.dataAccess.abstracts.DebitAccountDao;
import com.ersel.ebank.dataAccess.abstracts.DebitTransactionDao;
import com.ersel.ebank.dataAccess.abstracts.TransactionTypeDao;
import com.ersel.ebank.entities.concretes.DebitAccount;
import com.ersel.ebank.entities.concretes.DebitTransaction;
import com.ersel.ebank.entities.concretes.TransactionType;
import com.ersel.ebank.utilities.mappers.ModelMapperService;
import com.ersel.ebank.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Service
public class DebitTransactionManager implements DebitTransactionService {
    private DebitTransactionDao transactionDao;
    private DebitAccountDao accountDao;
    //private ModelMapperService modelMapperService;

    private TransactionTypeDao typeDao;

    @Override
    public SuccessResult add(DebitTransaction request) {

        //Set date and time
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
        request.setTransactionDate(formattedDateTime);

        //Set money process
        DebitAccount target = this.accountDao.getDebitAccountByAccountId(request.getDestinationId());
        DebitAccount main = this.accountDao.getDebitAccountByAccountId(request.getAccountId().getAccountId());

        if (target.getAccountId() == main.getAccountId()){
            //1+, 2-
            if (request.getTypeId().getTypeId() == 1){
                target.setBalance(target.getBalance() + request.getAmount());
            } else {
                target.setBalance(target.getBalance() - request.getAmount());
            }
        } else {
            target.setBalance(target.getBalance() + request.getAmount());
            main.setBalance(main.getBalance() - request.getAmount());
        }

        this.transactionDao.save(request);


        DebitTransaction reverse = new DebitTransaction();

        reverse.setTransactionDate(formattedDateTime);
        reverse.setAccountId(target);
        reverse.setDestinationId(main.getAccountId());
        if (request.getTypeId().getTypeId() == 1){
            TransactionType type = this.typeDao.findTransactionTypeByTypeId(2);
            reverse.setTypeId(type);
        } else {
            TransactionType type = this.typeDao.findTransactionTypeByTypeId(1);
            reverse.setTypeId(type);
        }
        reverse.setTransactionName(request.getTransactionName());
        reverse.setAmount(request.getAmount());

        this.transactionDao.save(reverse);


        return new SuccessResult("Transaction is created !");
    }

    @Override
    public List<DebitTransaction> getAll() {
        List<DebitTransaction> allTransactionList = this.transactionDao.findAll();
        return allTransactionList;
    }

    @Override
    public List<DebitTransaction> getByAccountId(int id) {
        List<DebitTransaction> getByAccountList = this.transactionDao.findDebitTransactionByAccountId_AccountId(id);
        return getByAccountList;
    }

    @Override
    public List<DebitTransaction> getByDestinationId(int id) {
        List<DebitTransaction> getbyDestinationList = this.transactionDao.findDebitTransactionsByDestinationId(id);
        return getbyDestinationList;
    }
}
