/*
 * package com.bornfire.xbrl.config;
 * 
 * import java.math.BigDecimal; import java.util.Date; import java.util.List;
 * import java.util.Map; import java.util.Properties;
 * 
 * import javax.mail.Message; import javax.mail.PasswordAuthentication; import
 * javax.mail.Session; import javax.mail.Transport; import
 * javax.mail.internet.InternetAddress; import javax.mail.internet.MimeMessage;
 * import javax.sql.DataSource;
 * 
 * import org.hibernate.SessionFactory; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.env.Environment; import
 * org.springframework.stereotype.Component; import
 * org.springframework.stereotype.Service;
 * 
 * import com.bornfire.xbrl.entities.EMAILREP; import
 * com.bornfire.xbrl.entities.EmailAlert;
 * 
 * @Configuration
 * 
 * @Component
 * 
 * @Service public class CronJobScheduler {
 * 
 * @Autowired EMAILREP emailRep;
 * 
 * @Autowired SessionFactory sessionFactory;
 * 
 * 
 * 
 * @Autowired Environment env;
 * 
 * @Autowired DataSource srcdataSource;
 * 
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(CronJobScheduler.class);
 * 
 * // @Scheduled(cron = "0 * * ? * *") // public void gmail() { // String
 * status; // // String host = "webmail.bornfire.in"; // final String user =
 * "baml@bornfire.in";// change accordingly // final String password =
 * "baml@MCS";// change accordingly // String to = "manivannan.b@bornfire.in";
 * // // System.out.println("host " + host + " user " + user + " password " + //
 * // password); // // // String to =
 * "kalaivanan.r@bornfire.in,manivannan.b@bornfire.in"; // // Properties props =
 * new Properties(); // props.put("mail.smtp.auth", "true"); // //
 * props.put("mail.smtp.starttls.enable", "true"); //
 * props.put("mail.smtp.host", host); // // use mail address from HTML form for
 * from address // props.put("mail.from", "baml@bornfire.in"); // // Session
 * session = Session.getInstance(props, new javax.mail.Authenticator() { //
 * protected PasswordAuthentication getPasswordAuthentication() { // return new
 * PasswordAuthentication(user, password); // } // }); // try { // MimeMessage
 * message = new MimeMessage(session); // message.setFrom(new
 * InternetAddress(user)); // InternetAddress[] parse =
 * InternetAddress.parse(to, true); // //
 * message.setRecipients(javax.mail.Message.RecipientType.TO, parse); // //
 * message.setSubject("PARAMETER CHANGED"); // // String det =
 * "MASTER /MANIVANNAN/BORNFIRE/"; // // String[] dt1 = det.split("/"); //
 * String message1 = "<i>Please find below the alert particulars,</i><br>"; //
 * for (String info : dt1) { // // message1 += "<b>" + info + "</b><br>"; // //
 * } // System.out.println(message1); // message.setContent(message1,
 * "text/html"); // Transport.send(message); // // status = "success"; //
 * logger.info(status); // } catch (Exception e) { // status = "Failure"; //
 * logger.info(status); // } // System.out.println(status); // }
 * 
 * //@Scheduled(cron = "0 * * ? * *") public String execute() throws Exception {
 * 
 * logger.info("EMAIL STARTS"); String nextPage = ""; String status;
 * 
 * int count = emailRep.getEmailSentCount(); String host =
 * env.getProperty("mail.host"); String user =
 * env.getProperty("mail.username");// change accordingly String password =
 * env.getProperty("mail.password");// change accordingly String port =
 * env.getProperty("mail.port"); if (count > 0) {
 * 
 * List<EmailAlert> lst_Objects = emailRep.getEmailDetails(); if (lst_Objects !=
 * null) { for (EmailAlert cmnVal : lst_Objects) {
 * 
 * Properties props = new Properties(); props.put("mail.smtp.auth", "true"); //
 * props.put("mail.smtp.starttls.enable", "true"); props.put("mail.smtp.host",
 * host); props.put("mail.smtp.port", port);
 * 
 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
 * protected PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication(user, password); } });
 * System.out.println("SEND MAIL..."); try { System.out.println("Hi");
 * MimeMessage msg = new MimeMessage(session); msg.setFrom(new
 * InternetAddress(user));
 * 
 * 
 * msg.addRecipient(Message.RecipientType.TO, new
 * InternetAddress(cmnVal.getEmail_id()));
 * msg.addRecipient(Message.RecipientType.CC, new
 * InternetAddress(cmnVal.getEmail_id_cc1())); if (cmnVal.getEmail_id_cc2() !=
 * null) { msg.addRecipient(Message.RecipientType.CC, new
 * InternetAddress(cmnVal.getEmail_id_cc2())); } msg.setSentDate(new Date());
 * msg.setSubject(cmnVal.getEmail_sub()); //
 * msg.setText(cmnVal.getEmail_body());
 * 
 * StringBuilder sb = new StringBuilder();
 * //sb.append("Dear Sir,").append(System.lineSeparator());
 * sb.append("Please find below the alert particulars,").append(System.
 * lineSeparator());
 * 
 * sb.append(cmnVal.getEmail_body());
 * 
 * msg.setText(sb.toString());
 * 
 * 
 * String det = cmnVal.getEmail_body();
 * 
 * String[] dt1 = det.split("/"); String message1 =
 * "<i>Please find below the alert particulars,</i><br><br>";
 * System.out.println(cmnVal.getEmail_sub()); if
 * (cmnVal.getEmail_sub().equals("Evidence Source of Fund Alert")) { message1 +=
 * "<b>Daily amount limit exceeded for the following customer:</b><br><br><br>";
 * 
 * message1 +="<table border=1><tr><td style=width:200px;><b>" +
 * dt1[0].toString() + "</b></td><td style=width:300px;><i>" + dt1[1].toString()
 * + "</i></td></tr>" + "<tr><td style=width:200px;><b>" + dt1[2].toString() +
 * "</b></td><td style=width: 300px;><i>" + dt1[3].toString() + "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[4].toString() +
 * "</b></td><td style=width: 300px; ><i>" + dt1[5].toString() +
 * "</i></td></tr>" + "<tr><td style=width:200px;><b>" + dt1[6].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[7].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[8].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[9].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[10].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[11].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[12].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[13].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[14].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[15].toString()+
 * "</i></td></tr></table>";
 * 
 * // message1 += "<table ><tr><td style=width:200px;><b>" + dt1[0].toString() +
 * "</b></td><td style=width:300px;><b>" + dt1[1].toString() + "</b></td></tr>";
 * // message1 += "<table><tr><td style=width:200px;><b>" + dt1[2].toString() +
 * "</b></td><td style=width: 300px;><b>" + dt1[3].toString() +
 * "</b></td></tr>"; // message1 += "<table><tr><td style=width:200px;><b>" +
 * dt1[4].toString() + "</b></td><td style=width: 300px; ><b>" +
 * dt1[5].toString() + "</b></td></tr>"; // message1 +=
 * "<table><tr><td style=width:200px;><b>" + dt1[6].toString() +
 * "</b></td><td style=width: 300px;><b>" + dt1[7].toString() +
 * "</b></td></tr></table>";
 * 
 * }else if (cmnVal.getEmail_sub().equals("Card Limit Alert")) { message1 +=
 * "<b>Card daily limit reached for the following customer:</b><br><br><br>";
 * 
 * message1 +="<table border=1><tr><td style=width:200px;><b>" +
 * dt1[0].toString() + "</b></td><td style=width:300px;><i>" + dt1[1].toString()
 * + "</i></td></tr>" + "<tr><td style=width:200px;><b>" + dt1[2].toString() +
 * "</b></td><td style=width: 300px;><i>" + dt1[3].toString() + "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[4].toString() +
 * "</b></td><td style=width: 300px; ><i>" + dt1[5].toString() +
 * "</i></td></tr>" + "<tr><td style=width:200px;><b>" + dt1[6].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[7].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[8].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[9].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[10].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[11].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[12].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[13].toString()+ "</i></td></tr>"
 * + "<tr><td style=width:200px;><b>" + dt1[14].toString()+
 * "</b></td><td style=width: 300px;><i>" + dt1[15].toString()+
 * "</i></td></tr></table>";
 * 
 * // message1 += "<table ><tr><td style=width:200px;><b>" + dt1[0].toString() +
 * "</b></td><td style=width:300px;><b>" + dt1[1].toString() + "</b></td></tr>";
 * // message1 += "<table><tr><td style=width:200px;><b>" + dt1[2].toString() +
 * "</b></td><td style=width: 300px;><b>" + dt1[3].toString() +
 * "</b></td></tr>"; // message1 += "<table><tr><td style=width:200px;><b>" +
 * dt1[4].toString() + "</b></td><td style=width: 300px; ><b>" +
 * dt1[5].toString() + "</b></td></tr>"; // message1 +=
 * "<table><tr><td style=width:200px;><b>" + dt1[6].toString() +
 * "</b></td><td style=width: 300px;><b>" + dt1[7].toString() +
 * "</b></td></tr></table>";
 * 
 * } else {
 * 
 * for (String info : dt1) {
 * 
 * message1 += "<b>" + info + "</b><br>";
 * 
 * } } System.out.println(message1); msg.setContent(message1, "text/html");
 * 
 * Transport.send(msg);
 * 
 * nextPage = "success";
 * 
 * } catch (Exception E) {
 * System.out.println("Oops something has gone pearshaped!");
 * System.out.println(E); nextPage = "error"; } if (nextPage.equals("success"))
 * { BigDecimal srl = cmnVal.getEmail_srl_no(); EmailAlert cv =
 * emailRep.getEmailbySRl(srl);
 * 
 * cv.setSend_flg("Y"); cv.setMsg_status("Delivered Successfully");
 * 
 * emailRep.save(cv); } } } }
 * 
 * return nextPage;
 * 
 * }
 * 
 * public void setSession(Map<String, Object> arg0) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * 
 * }
 */