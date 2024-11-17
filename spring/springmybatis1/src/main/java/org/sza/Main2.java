package org.sza;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sza.Service.AccountService;
import org.sza.config.SpringConfig;
import org.sza.domain.Account;

import javax.sql.DataSource;


public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DataSource dataSource = context.getBean(DataSource.class);
//        System.out.println(dataSource);
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }
}
