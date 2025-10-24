package pages;

import org.testng.annotations.DataProvider;

public class DataRepo {
    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getLoginData(){
        return new Object[][]{
                {"username", "admin"},
                {"password", "Admin123"}
        };
    }
    @DataProvider(name = "PatientData", parallel = true)
    public Object[][] getPatientData(){
        return new Object[][]{
                {"patient1", "Scarlett Johansson"},
                {"patient2", "Jason Very Patient"}
        };
    }
}
