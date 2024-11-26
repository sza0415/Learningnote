package org.sza;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sza.config.SpringConfig;
import org.sza.entity.Account;
import org.sza.service.AccountService;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }
}
