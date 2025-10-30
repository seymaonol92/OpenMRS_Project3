package pages;

import org.testng.annotations.DataProvider;

public class DataRepo {
    @DataProvider(name = "UsernameData", parallel = true)
    public Object[][] getUsernameData(){
        return new Object[][]{
                {"admin"},
        };
    }

    @DataProvider(name = "PasswordData", parallel = true)
    public Object[][] getPasswordData(){
        return new Object[][]{
                {"Admin123"},
        };
    }
    @DataProvider(name = "PatientData", parallel = true)
    public Object[][] getPatientData(){
        return new Object[][]{
                {"Scarlett Johansson"}
        };
    }
    @DataProvider(name = "InvalidPatientData", parallel = true)
    public Object[][] getInvalidPatientData(){
        return new Object[][]{
                {"Invalid Patient"}
        };
    }

    @DataProvider(name = "PatientRegistrationData", parallel = true)
    public Object[][] getPatientRegistrationData() {
        return new Object[][]{
                {"Delpiero", "Alexsandro", "Male", "10-01-1992", "123 Test Caddesi, Ankara"}
        };
    }

    @DataProvider(name = "PatientDeletionData", parallel = true)
    public Object[][] getPatientDeletionData() {
        return new Object[][]{
                {"Delpiero ", "The patient was discharged"}
        };

    }
    @DataProvider(name = "IDsData", parallel = true)
    public Object[][] getIDsData() {
        return new Object[][]{
                {"10003YW", "100040U"}

        };
    }
    @DataProvider(name = "invalid login credentials")
    public Object[][] getInvalidData() {
        return new Object[][] {
                {"admin1", "invalidPass1"},
                {"admin2", "invalidPass2"},
                {"admin3", "invalidPass3"},
                {"admin4", "invalidPass4"},
                {"admin5", "invalidPass5"},
                {"admin6", "invalidPass6"}
        };
    }
    @DataProvider(name = "valid login credentials")
    public Object[][] getValidData(){
        return new Object[][]{
                {"admin", "Admin123"},
        };

    }
}
