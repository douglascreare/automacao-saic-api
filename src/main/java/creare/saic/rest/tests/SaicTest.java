package creare.saic.rest.tests;

import creare.saic.rest.core.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaicTest extends BaseTest {

    private String token;
    private static String idGeradoDevice;
    private static String idGeradoVehicle;
    private static String idGeradoOperators;
    private static String idGeradoLocations;

    @Before
    public void login() {
        token = given()
            .body("{ \"user\": \"douglas.muniz\", \"pass\": 123456}")
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .extract().path("token");
    }

    //-----------------GET POST PUT DELETE DA COLEÇÃO DEVICES-----------------

    @Test
    public void teste_01PutDevices() {
        idGeradoDevice = given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"macAddress\": \"F2DC9C88960\", \"type\": \"Tag Ble\", \"name\": \"CRS400014455TESTES072\", \"beaconType\": \"HARVESTER\", \"sequential\": 35}")
        .when()
            .put("/devices")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Inserted successfully"))
            .extract().path("id");
    }

    @Test
    public void teste_02PostDevices() {
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoDevice + "\" , \"name\": \"CRS400014455TESTES0994\"}")
        .when()
            .post("/devices")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Updated successfully"));
    }

    @Test
    public void teste_03GetDevices() {
        given()
            .header("Authorization", "Bearer " + token)
            .param("id", idGeradoDevice)
        .when()
            .get("/devices")
        .then()
            .statusCode(200)
            .body("query.id", Matchers.is(idGeradoDevice));
    }

    @Test
    public void teste_04DeleteDevices(){
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoDevice + "\"}")
        .when()
            .delete("/devices")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Deleted successfully"));
    }

    //-----------------GET POST PUT DELETE DA COLEÇÃO VEHICLES-----------------

    @Test
    public void teste_05PutVehicles(){
        idGeradoVehicle = given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"type\": \"Harvester\", \"name\": 60431, \"deviceId\": 123}")
        .when()
            .put("/vehicles")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Inserted successfully"))
            .extract().path("id");
    }

    @Test
    public void teste_06PostVehicles() {
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoVehicle + "\" , \"name\": 665552}")
        .when()
            .post("/vehicles")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Updated successfully"));
    }

    @Test
    public void teste_07GetVehicles() {
        given()
            .header("Authorization", "Bearer " + token)
            .param("id", idGeradoVehicle)
        .when()
            .get("/vehicles")
        .then()
            .statusCode(200)
            .body("query.id", Matchers.is(idGeradoVehicle));
    }

    @Test
    public void teste_08DeleteVehicles(){
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoVehicle + "\"}")
        .when()
            .delete("/vehicles")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Deleted successfully"));
    }

    //-----------------GET POST PUT DELETE DA COLEÇÃO OPERATORS-----------------*

    @Test
    public void teste_09PutOperators() {
        idGeradoOperators = given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"name\": \"Testes Operador\", \"operatorType\": \"Harvester\", \"matricula\": 4455}")
        .when()
            .put("/operators")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Inserted successfully"))
            .extract().path("id");
    }

    @Test
    public void teste_10PostOperators() {
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoOperators + "\" , \"operatorType\": \"Harvester\" , \"matricula\": 665566}")
        .when()
            .post("/operators")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Updated successfully"));
    }

    @Test
    public void teste_11GetOperators() {
        given()
            .header("Authorization", "Bearer " + token)
            .param("id", idGeradoOperators)
        .when()
            .get("/operators")
        .then()
            .statusCode(200)
            .body("query.id", Matchers.is(idGeradoOperators));
    }

    @Test
    public void teste_12DeleteOperators(){
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoOperators + "\"}")
        .when()
            .delete("/operators")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Deleted successfully"));
    }

//-----------------GET POST PUT DELETE DA COLEÇÃO LOCATIONS-----------------*

    @Test
    public void teste_13PutLocations() {
        idGeradoLocations = given()
            .header("Authorization", "Bearer " + token)
            .body("{\"name\": \"Moenda12345\", \"type\": \"Balança de Entrada\", \"topic\": \"topic Teste055\"}")
        .when()
            .put("/locations")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Inserted successfully"))
            .extract().path("id");
    }

    @Test
    public void teste_14PostLocations() {
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoLocations + "\" , \"type\": \"Moenda\" , \"topic\": \"Teste\"}")
        .when()
            .post("/locations")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Updated successfully"));
    }

    @Test
    public void teste_15GetLocations() {
        given()
            .header("Authorization", "Bearer " + token)
            .param("id", idGeradoOperators)
        .when()
            .get("/locations")
        .then()
            .statusCode(200)
            .body("query.id", Matchers.is(idGeradoOperators));
    }

    @Test
    public void teste_16DeleteLocations(){
        given()
            .header("Authorization", "Bearer " + token)
            .body("{ \"id\": \"" + idGeradoLocations + "\"}")
        .when()
            .delete("/locations")
        .then()
            .statusCode(200)
            .body("message", Matchers.is("Deleted successfully"));
    }

}
