package com.game4men.aigroove.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendInquiryAnswerEmail(String to, String inquiryTitle, String answerTitle, String answerContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("[AI Groove] 문의하신 내용에 대한 답변이 등록되었습니다.");

            String emailContent = String.format("""
                안녕하세요, AI Groove입니다.
                
                문의하신 내용 "%s"에 대한 답변이 등록되었습니다.
                
                [답변 제목]
                %s
                
                [답변 내용]
                %s
                
                추가 문의사항이 있으시다면 언제든 문의해 주시기 바랍니다.
                감사합니다.
                
                AI Groove 드림
                """, inquiryTitle, answerTitle, answerContent);

            helper.setText(emailContent, false);
            mailSender.send(message);
            
        } catch (MessagingException e) {
            throw new RuntimeException("이메일 발송에 실패했습니다.", e);
        }
    }
} 