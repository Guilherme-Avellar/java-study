package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.CadastoEntregasService;

import java.util.List;
import java.util.Map;

public class CadastroEntregasSteps {
    CadastoEntregasService cadastoEntregasService = new CadastoEntregasService();

    @Dado("que eu tenha os seguintes dados de entrega:")
    public void queEuTenhaOsSeguintesDadosDeEntrega(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastoEntregasService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeEntregas(String endpoint) {
        cadastoEntregasService.createDelivery(endpoint);
    }

    @Entao("status code da resposta deve ser {int}")
    public void statusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastoEntregasService.response.statusCode());
    }
}
