import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class mailsend {
			public static void main(String[] args) {
			      String from = "advait1152@gmail.com";
			      String password = "lfbx sgsx nttv ptvr";
			      
			      String to ="incappclasscode@gmail.com";
			      String subject = "Testing mail from Java Application";
			      String msg = "This is a testing msg send using Java Application";
			      
			      Properties prop=new Properties();
			      prop.put("mail.smtp.host", "smtp.gmail.com");
			      prop.put("mail.smtp.port", "465");
			      prop.put("mail.smtp.ssl.enable", "true");
			      prop.put("mail.smtp.auth", "true");
			      
			      Session session=Session.getInstance(prop, new Authenticator(){

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from,password);
					}
			    	  
			      });
			      
			      MimeMessage message=new MimeMessage(session);
			      
			      MimeMultipart multi = new MimeMultipart();
			      String path="C:\\Users\\advai\\Downloads\\Screenshot 2024-07-01 120458.png";
			     // String path="D:\\Java Project\\Pattern\\src\\p1.java";
			      try {
			    	  message.setFrom(from);
			    	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			    	  message.setSubject(subject);
			    	  //message.setText(msg);
			    	  MimeBodyPart text=new MimeBodyPart();
			    	  text.setText(msg);
			    	  
			    	  MimeBodyPart filepath=new MimeBodyPart();
			    	  File file=new File(path);
			    	  filepath.attachFile(file);
			    	  
			    	  multi.addBodyPart(filepath);
			    	  multi.addBodyPart(text);
			    	  
			    	  message.setContent(multi);
				      Transport.send(message);
				      System.out.println("Success");
			      }catch(Exception e) {
			    	  e.printStackTrace();
			      }
	
	}
}
