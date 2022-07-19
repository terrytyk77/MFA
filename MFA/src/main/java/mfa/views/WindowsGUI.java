package mfa.views;

public class WindowsGUI extends  GUI {
    @Override
    public void start() {

        loginLayout = new LoginLayout(this);
        setLoginPanel(loginLayout.getPanel());

        authenticationLayout = new AuthenticationLayout(this);
        setAuthenticationPanel(authenticationLayout.getPanel());

        applicationLayout = new ApplicationLayout(this);
        setApplicationPanel(applicationLayout.getPanel());

        super.start();
    }
}
