/*
 * Copyright 2018-2021 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.syntheticdatagenerator.types;


import java.util.Random;
import java.util.StringJoiner;
import java.io.Serializable;

/**
 * @class Bank Details
 * @brief This class creates random values for a bank account
 * @details The Sort Code is defined by a number of 6 digits while the Account Number is defined by 8 digits
 */
public class BankDetails implements Serializable{
    private static final int SORT_CODE_DIGITS = 6;
    private static final int ACCOUNT_NUMBER_DIGITS = 8;
    private String sortCode;
    private String accountNumber;

    /**
     * @brief This method generates bank details
     * @param random random value
     * @return generated bank details
     */
    public static BankDetails generate(final Random random) {
        BankDetails bankDetails = new BankDetails();
        bankDetails.sortCode = String.format("%0" + SORT_CODE_DIGITS + "d", random.nextInt((int) Math.pow(10, SORT_CODE_DIGITS)));
        bankDetails.accountNumber = String.format("%0" + ACCOUNT_NUMBER_DIGITS + "d", random.nextInt((int) Math.pow(10, ACCOUNT_NUMBER_DIGITS)));
        return bankDetails;
    }

    /**
     * @brief This method returns a sort code
     * @return sort code
     */
    public String getSortCode() {
        return sortCode;
    }

    /**
     * @brief This method assigns a sort code
     * @param sortCode sort code
     */
    public void setSortCode(final String sortCode) {
        this.sortCode = sortCode;
    }

    /**
     * @brief This method returns an account number
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @brief This method assigns an account number
     * @param accountNumber account number
     */
    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @brief Change attributes to a string format
     * @return attributes in a string format
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", BankDetails.class.getSimpleName() + "[", "]")
                .add("sortCode='" + sortCode + "'")
                .add("accountNumber='" + accountNumber + "'")
                .toString();
    }
}
