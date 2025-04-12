package com.example.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender javaMailSender;



}
