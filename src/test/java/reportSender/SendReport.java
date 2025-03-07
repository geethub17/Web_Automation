package reportSender;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import reader.PropertiesReader;
import stepDefinitions.BaseClass;

public class SendReport extends BaseClass {

	public SendReport() {
		propertiesReader = new PropertiesReader();
	}

	public String host = "smtpinternal.abc.com";
	public String browser = propertiesReader.getBrowserType();
	public String URL = propertiesReader.getURL();
	public String from;
	public String[] ToAdresses = { "abc@gmail.com"

	};

	public void triggerMail(String reportName, String reportPath)
			throws IOException, AddressException, MessagingException {

		try {
			/*
			 * 1. System.getProperties() method returns the properties of the system like OS
			 * name, user name, user home, java version etc.
			 * 
			 * 2. We are adding the host to the properties set.
			 * 
			 * 3. Here, we are triggering the SMTP without authentication.
			 * 
			 * 4. If we try to SMTP with authentication, "java.net.UnknownHostException"
			 * will be triggered due to firewall issue.
			 */

			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", host);

			/*
			 * Creating Session object
			 * 
			 * The Session class represents a mail session and is not subclassed.It collects
			 * together properties and defaults used by the mail API's.
			 */
			Session session = Session.getInstance(properties, null);

			/*
			 * Creating MimeMessage object
			 * 
			 * The MimeMessage class allows the users to create own style by passing the
			 * attributes. We can set the recipients here.
			 * 
			 * Example: Sender name will be displayed as the input of setFrom method.
			 */
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Application_Automation"));

			/* Setting the string value type as address */
			InternetAddress[] recipients = new InternetAddress[ToAdresses.length];

			for (int i = 0; i < ToAdresses.length; i++) {
				recipients[i] = new InternetAddress(ToAdresses[i]);
			}

			/* Adding the recipients to the message object. */
			for (int j = 0; j < ToAdresses.length; j++) {
				message.addRecipient(Message.RecipientType.TO, recipients[j]);
			}

			/* This date and time will be used as part of mail subject. */
			Date dt = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String currentDateAndTime = formatter.format(dt);

			/* Set subject of the mail */
			message.setSubject("Application automation " + reportName.toLowerCase() + " on " + currentDateAndTime);

			/* Set body of the mail */
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Hello everyone, Good day! \n" + "\n"
					+ "All scenarios have been executed. Please find the attached report for execution metrics.  \n"
					+ "\n" + "Environment URL: " + URL + "\n" + "\n"+ "Browser: " + browser + "\n" + "\n"
					+ "This is an automated mail please do not reply . \n" + "\n" + "Team,\n" + "Application QA Automation.");

			/* Adding the attachment to the mail. */
			File file = new File(System.getProperty("user.dir") + reportPath);
			BodyPart messageBodyPart_2 = new MimeBodyPart();
			DataSource source = new FileDataSource(file.getAbsolutePath());
			messageBodyPart_2.setDataHandler(new DataHandler(source));
			messageBodyPart_2.setFileName("Application_" + reportName + ".html");

			/* Clubbing the subject and body of mail. */
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart_2);
			message.setContent(multipart);

			/* Triggers mail. */
			Transport.send(message);

		} catch (AddressException ae) {
			System.out.println("Address exception: " + ae);
		} catch (MessagingException me) {
			System.out.println("Messaging exception: " + me);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}