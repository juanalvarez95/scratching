package com.tevolvers.scratchingfallabelashop.utils;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import javax.activation.FileDataSource;

public class SendMail {

    public static void withResults(){
        Email email = EmailBuilder.startingBlank()
                .from("Scratching automation", Variable.fromProperties().getValue("mail.from"))
                .to(Variable.fromProperties().getValue("mail.to"))
                .withSubject("Prices results")
                .withPlainText("Hello, this is a little that we can do")
                .withAttachment("products.csv", new FileDataSource("products.csv"))
                .buildEmail();

        MailerBuilder.withSMTPServer(Variable.fromProperties().getValue("mail.smtp"),
                Integer.parseInt(Variable.fromProperties().getValue("mail.port")),
                Variable.fromProperties().getValue("mail.user"),
                Variable.fromProperties().getValue("mail.password"))
                .buildMailer().sendMail(email);
    }
}
