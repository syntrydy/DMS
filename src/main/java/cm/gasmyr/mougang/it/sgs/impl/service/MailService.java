package cm.gasmyr.mougang.it.sgs.impl.service;

import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.mail.Message;

@Service
public interface MailService {
	boolean sendMessageTo(Message message);
}
