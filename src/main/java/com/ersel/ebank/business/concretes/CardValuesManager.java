package com.ersel.ebank.business.concretes;

import com.ersel.ebank.business.abstracts.CardValuesService;
import com.ersel.ebank.business.responses.GetCardValuesResponse;
import com.ersel.ebank.dataAccess.abstracts.DebitTransactionDao;
import com.ersel.ebank.entities.concretes.DebitTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardValuesManager implements CardValuesService {
    private DebitTransactionDao transactionDao;

    @Override
    public GetCardValuesResponse getValues(int id) {
        List<DebitTransaction> incomeList = this.transactionDao.findDebitTransactionsByAccountId_AccountIdAndTypeId_TypeId(id,1);
        int incomes = 0;
        for (DebitTransaction item : incomeList) {
            incomes += item.getAmount();
        }
        List<DebitTransaction> expenseList = this.transactionDao.findDebitTransactionsByAccountId_AccountIdAndTypeId_TypeId(id,2);
        int expenses = 0;
        for (DebitTransaction item : expenseList) {
            expenses += item.getAmount();
        }
        int balance = incomes - expenses;
        GetCardValuesResponse response = new GetCardValuesResponse();
        response.setBalance(balance);
        response.setExpenses(expenses);
        response.setIncomes(incomes);

        if (balance > 0){
            response.setStatus(true);
        } else {
            response.setStatus(false);
        }

        return response;
    }

    @Override
    public GetCardValuesResponse getValuesByCustomerId(int customerId) {
        List<DebitTransaction> incomeList = this.transactionDao.findDebitTransactionsByAccountId_Customer_CustomerIdAndTypeId_TypeId(customerId, 1);
        int incomes = 0;
        for (DebitTransaction item : incomeList) {
            incomes += item.getAmount();
        }
        List<DebitTransaction> expenseList = this.transactionDao.findDebitTransactionsByAccountId_Customer_CustomerIdAndTypeId_TypeId(customerId, 2);
        int expenses = 0;
        for (DebitTransaction item : expenseList) {
            expenses += item.getAmount();
        }
        int balance = incomes - expenses;
        GetCardValuesResponse response = new GetCardValuesResponse();
        response.setBalance(balance);
        response.setExpenses(expenses);
        response.setIncomes(incomes);

        if (balance > 0){
            response.setStatus(true);
        } else {
            response.setStatus(false);
        }

        return response;
    }
}
