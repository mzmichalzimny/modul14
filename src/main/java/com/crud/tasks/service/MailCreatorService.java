package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildDailyTasksEmail(int taskCount) {
        Context context = new Context();
        context.setVariable("message", "Masz " + taskCount + " zadania.");
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Zobacz zadania");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview_message", "Twoje codzienne zadania");
        context.setVariable("goodbye_message", "Miłego dnia!");
        context.setVariable("company_details", adminConfig.getCompanyName());
        return templateEngine.process("mail/daily-tasks-mail", context);
    }
}