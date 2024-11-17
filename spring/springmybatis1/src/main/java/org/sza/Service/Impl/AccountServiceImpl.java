package org.sza.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sza.Service.AccountService;
import org.sza.mapper.AccountMapper;
import org.sza.domain.Account;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
        accountMapper.save(account);
    }

    public void delete(Integer id) {
        accountMapper.delete(id);
    }

    public void update(Account account) {
        accountMapper.update(account);
    }

    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }
}
