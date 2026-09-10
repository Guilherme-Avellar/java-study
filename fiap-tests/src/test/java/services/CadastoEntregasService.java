package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.EntregaModel;

import static io.restassured.RestAssured.given;

public class CadastoEntregasService {

    EntregaModel entregaModel = new EntregaModel();
    public Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    // url da api, como nesse caso é apenas estudo, etá como localhost mesmo
    String baseUrl = "http://localhost:8080";
    String idDelivery;

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "numeroPedido" -> entregaModel.setNumeroPedido(Integer.parseInt(value));
            case "nomeEntregador" -> entregaModel.setNomeEntregador(value);
            case "statusEntrega" -> entregaModel.setStatusEntrega(value);
            case "dataEntrega" -> entregaModel.setDataEntrega(value);
            default -> throw new IllegalStateException("Unexpected field: " + field);
        }
    }

    public void createDelivery(String endpoint) {
        String url = baseUrl + endpoint;
        String body = gson.toJson(entregaModel);
        // reponsavel pelo protocolo http
        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public void retrieveId() {
        idDelivery = String.valueOf(gson.fromJson(response.jsonPath().prettify(), EntregaModel.class).getNumeroPedido());
    }

    public void deleteDelivery(String endpoint) {
        String url = baseUrl + endpoint;
        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
