package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServerAndEnsureUser() throws IOException, MessagingException {
    app.mail().start();
    app.chpass().loginAsAdminAndManage();
    if(!app.chpass().testUserIsHere()) {
      app.registration().logout();
      app.registration().start("Oleg", "oleg@localhost.localdomain");
      List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
      String confirmationLink = app.registration().findConfirmationLink(mailMessages, "oleg@localhost.localdomain");
      app.registration().finish(confirmationLink, "password");
      app.registration().logout();
      app.chpass().loginAsAdminAndManage();
    }
  }

  @Test
  public void testChangePassword() throws MessagingException, IOException {
    app.chpass().clickOnTestUserAndResetPsw();
    List<MailMessage> newMessages = app.mail().waitForMail(1, 10000);
    String resetLink = app.chpass().findResetPasswordLink(newMessages, "oleg@localhost.localdomain");
    app.chpass().changePassword(resetLink, "testpass");
    assertTrue(app.newSession().login("Oleg", "testpass"));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}


//Реализовать сценарий смены пароля пользователю баг-трекера MantisBT администратором системы:
//
//    Администратор входит в систему, переходит на страницу управления пользователями, выбирает заданного пользователя и нажимает кнопку Reset Password
//    Отправляется письмо на адрес пользователя, тесты должны получить это письмо, извлечь из него ссылку для смены пароля, пройти по этой ссылке и изменить пароль.
//    Затем тесты должны проверить, что пользователь может войти в систему с новым паролем.
//
//Изменить конфигурацию MantisBT можно вручную, не обязательно подменять конфигурационный файл при запуске тестов. Пользователя тоже можно заранее создать вручную.
//
//Однако получить информацию об идентификаторе и/или логине пользователя тесты должны самостоятельно во время выполнения.
// Можно это сделать, например, загрузив информацию о пользователях из базы данных.
//
//Почтовый сервер можно запускать непосредственно внутри тестов.
//
//Шаги 1 и 2 необходимо выполнять через пользовательский интерфейс, а шаг 3 можно выполнить на уровне протокола HTTP.