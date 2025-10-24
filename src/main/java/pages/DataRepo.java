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

    @DataProvider(name = "PatientRegistrationData", parallel = true)
    public Object[][] getPatientRegistrationData() {
        return new Object[][]{
                {"Delpiero", "Alexsandro", "Male", "10-01-1992", "123 Test Caddesi, Ankara"},
                {"Vincenzo", "Locatelli", "Male", "18-06-1974", "456 Milli Sokak, İstanbul"}
        };
    }

    @DataProvider(name = "PatientDeletionData", parallel = true)
    public Object[][] getPatientDeletionData() {
        return new Object[][]{
                {"Delpiero ", "The patient was discharged"},
                {"Vincenzo ", "The patient was discharged"}
        };
    }
}
