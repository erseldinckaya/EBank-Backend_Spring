package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.business.responses.GetCardValuesResponse;

public interface CardValuesService {
    GetCardValuesResponse getValues(int id);
}
