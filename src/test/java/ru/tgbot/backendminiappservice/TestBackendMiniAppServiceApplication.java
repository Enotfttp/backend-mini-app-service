package ru.tgbot.backendminiappservice;

import org.springframework.boot.SpringApplication;

public class TestBackendMiniAppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(BackendMiniAppServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
