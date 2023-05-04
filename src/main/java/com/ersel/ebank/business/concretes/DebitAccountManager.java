package com.ersel.ebank.business.concretes;


import com.ersel.ebank.business.abstracts.DebitAccountService;
import com.ersel.ebank.business.requests.CreateDebitAccountRequest;
import com.ersel.ebank.dataAccess.abstracts.DebitAccountDao;
import com.ersel.ebank.entities.concretes.DebitAccount;
import com.ersel.ebank.utilities.mappers.ModelMapperService;
import com.ersel.ebank.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class DebitAccountManager implements DebitAccountService {

    private DebitAccountDao debitAccountDao;
    private ModelMapperService modelMapperService;


    @Override
    public SuccessResult add(CreateDebitAccountRequest request) {
        DebitAccount debitAccount = this.modelMapperService.forRequest().map(request, DebitAccount.class);
        debitAccount.setBalance(0);

        Random rand = new Random();

        //Create random debit card number
        int rand_int1 = rand.nextInt(8999) + 1000;
        int rand_int2 = rand.nextInt(8999) + 1000;
        int rand_int3 = rand.nextInt(8999) + 1000;
        int rand_int4 = rand.nextInt(8999) + 1000;

        String rand_one = Integer.toString(rand_int1);
        String rand_two = Integer.toString(rand_int2);
        String rand_three = Integer.toString(rand_int3);
        String rand_four = Integer.toString(rand_int4);

        String cardNo = rand_one + " " + rand_two + " " + rand_three + " " +rand_four;
        debitAccount.setCardNumber(cardNo);

        //Create experiment date for card
        int rand_exp1 = rand.nextInt(11)+1;
        String exp = Integer.toString(rand_exp1);
        if (rand_exp1 > 9){
            String expNo = exp + "/25";
            debitAccount.setExpDate(expNo);
        } else {
            String expNo = "0"+ exp + "/25";
            debitAccount.setExpDate(expNo);
        }

        //Create cvc
        int rand_cvc = rand.nextInt(899)+100;
        debitAccount.setCvc(rand_cvc);

        //Set date and time

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
        debitAccount.setOpenningDate(formattedDateTime);


        this.debitAccountDao.save(debitAccount);




        return new SuccessResult("Your new debit card is created !");
    }

    @Override
    public List<DebitAccount> getDebitsByCustomerId(int id) {
        return this.debitAccountDao.getDebitAccountByCustomer_CustomerId(id);
    }

    @Override
    public DebitAccount getDebitAccountByAccountId(int id) {
        return this.debitAccountDao.getDebitAccountByAccountId(id);
    }

    @Override
    public List<DebitAccount> getCards() {
        return this.debitAccountDao.findAll();
    }

    @Override
    public SuccessResult deleteDebitCard(int id) {
        this.debitAccountDao.deleteById(id);
        return new SuccessResult("Your deletion request has been fulfilled.");
    }
}
