package cm.gasmyr.mougang.it.sgs.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.impl.service.MailService;
import cm.gasmyr.mougang.it.sgs.mail.Message;

@Service
public class MailServiceImpl implements MailService {
	private final String MAIL_SENDER = "defense.app@gmail.com";

	MailSender mailer;

	@Autowired
	MailServiceImpl(MailSender mailer) {
		this.mailer = mailer;
	}

	@Override
	public boolean sendMessageTo(Message mesg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Defense Information");
		message.setText("Hi " + mesg.getName().toUpperCase()
				+ mesg.getContent());
		message.setTo(mesg.getEmail());
		message.setFrom(MAIL_SENDER);
		try {
			mailer.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
