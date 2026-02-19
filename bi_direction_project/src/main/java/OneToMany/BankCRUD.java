package OneToMany;

import java.util.List;

public interface BankCRUD {
	void savebank(Bank bank);
	void updateBank(int id,Bank bank);
	Bank findBankById(int id);
	Bank findBankByName(String name);
	void giveAccountToBank(int bankId, Account newAccount);
	void giveAccountsToBank(int bankId, List<Account>accounts);
	void findAllAccountsInBank(int bankId);
	void findAllAccountsInBank(String bankName);
}
//use cascade type to help